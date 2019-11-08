/*
 * Copyright 2014-2016 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kaaproject.kaa.server.control.service.loadmgmt;

import static java.text.MessageFormat.format;
import static org.kaaproject.kaa.server.common.zk.ServerNameUtil.getNameFromConnectionInfo;

import org.apache.thrift.TException;
import org.kaaproject.kaa.server.common.thrift.KaaThriftService;
import org.kaaproject.kaa.server.common.thrift.gen.bootstrap.BootstrapThriftService;
import org.kaaproject.kaa.server.common.thrift.gen.bootstrap.BootstrapThriftService.Client;
import org.kaaproject.kaa.server.common.thrift.gen.bootstrap.ThriftOperationsServer;
import org.kaaproject.kaa.server.common.thrift.gen.operations.OperationsThriftService;
import org.kaaproject.kaa.server.common.thrift.gen.operations.RedirectionRule;
import org.kaaproject.kaa.server.common.thrift.util.ThriftActivity;
import org.kaaproject.kaa.server.common.thrift.util.ThriftClient;
import org.kaaproject.kaa.server.common.thrift.util.ThriftExecutor;
import org.kaaproject.kaa.server.common.zk.ServerNameUtil;
import org.kaaproject.kaa.server.common.zk.bootstrap.BootstrapNodeListener;
import org.kaaproject.kaa.server.common.zk.control.ControlNode;
import org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo;
import org.kaaproject.kaa.server.common.zk.gen.OperationsNodeInfo;
import org.kaaproject.kaa.server.common.zk.operations.OperationsNodeListener;
import org.kaaproject.kaa.server.control.service.loadmgmt.dynamicmgmt.OperationsServerLoadHistory;
import org.kaaproject.kaa.server.control.service.loadmgmt.dynamicmgmt.Rebalancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * DynamicLoadManager Class.
 *
 * @author Andrey Panasenko
 */
public class DynamicLoadManager implements OperationsNodeListener, BootstrapNodeListener {


  private static final int DEFAULT_PRIORITY = 10;
  private static final Logger LOG = LoggerFactory.getLogger(DynamicLoadManager.class);

  /**
   * Map to store Operations servers, key - DNS name host:port.
   */
  private final Map<Integer, OperationsServerMeta> opsServersMap;

  /**
   * Map to store bootstrap services, key - DNS name host:port.
   */
  private final Map<String, BootstrapNodeInfo> bootstrapsMap;


  private LoadDistributionService loadDistributionService;

  /**
   * The last bootstrap services update failed.
   */
  private boolean lastBootstrapServersUpdateFailed = false;

  /**
   * Time to live of Operations server load history, in ms.
   */
  private long opsLoadHistoryTtl = 600000;

  /**
   * The Constructor.
   *
   * @param loadDistributionService the load distribution service
   */
  public DynamicLoadManager(LoadDistributionService loadDistributionService) {
    setLoadDistributionService(loadDistributionService);
    opsServersMap = new ConcurrentHashMap<Integer, OperationsServerMeta>();
    bootstrapsMap = new ConcurrentHashMap<String, BootstrapNodeInfo>();
    // Translate seconds to ms
    opsLoadHistoryTtl = loadDistributionService.getOpsServerHistoryTtl() * 1000;
  }

  /**
   * Run recalculate process for Operations server Load optimization.
   */
  public void recalculate() {

    LOG.info("DynamicLoadManager recalculate() started... lastBootstrapServersUpdateFailed {}",
        lastBootstrapServersUpdateFailed);

    if (lastBootstrapServersUpdateFailed) {
      LOG.trace("Registred {} Bootstrap servers", bootstrapsMap.size());
      lastBootstrapServersUpdateFailed = false;
      for (BootstrapNodeInfo bootstrapNodeInfo : bootstrapsMap.values()) {
        updateBootstrap(bootstrapNodeInfo);
      }
    }
    if (loadDistributionService.getRebalancer() != null) {
      Map<Integer, OperationsServerLoadHistory> opsServerHistory = new HashMap<>();
      for (Integer accessPointId : opsServersMap.keySet()) {
        opsServerHistory.put(accessPointId, opsServersMap.get(accessPointId).history);
      }
      Map<Integer, List<RedirectionRule>> rules = loadDistributionService
          .getRebalancer()
          .recalculate(opsServerHistory);
      LOG.trace("DynamicLoadManager recalculate() got {} redirection rules", rules.size());
      for (Integer accessPointId : rules.keySet()) {
        if (opsServersMap.containsKey(accessPointId)) {
          sendRedirectionRule(accessPointId, opsServersMap.get(accessPointId).nodeInfo,
              rules.get(accessPointId));
        } else {
          LOG.error("Operations server {} redirection rule exist, "
              + "but NO server available, skip setting rule.", accessPointId);
        }
      }
    }
  }

  /**
   * Register listeners for Operations server nodes updates and Bootstrap
   * nodes updates.
   */
  public void registerListeners() {
    LOG.trace("DynamicLoadManager register listeners...");
    ControlNode pm = getLoadDistributionService().getZkService().getControlZkNode();
    pm.addListener((OperationsNodeListener) this);
    pm.addListener((BootstrapNodeListener) this);
  }

  /**
   * Deregister listeners for Operations server nodes updates and Bootstrap
   * nodes updates.
   */
  public void deregisterListeners() {
    LOG.trace("DynamicLoadManager deregister listeners...");
    ControlNode pm = getLoadDistributionService().getZkService().getControlZkNode();
    pm.removeListener((OperationsNodeListener) this);
    pm.removeListener((BootstrapNodeListener) this);
  }


  /*
   * (non-Javadoc)
   *
   * @see org.kaaproject.kaa.server.common.zk.bootstrap.BootstrapNodeListener#
   * onNodeAdded(org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo)
   */
  @Override
  public void onNodeAdded(BootstrapNodeInfo nodeInfo) {
    final String dnsName = getNameFromConnectionInfo(nodeInfo.getConnectionInfo());
    LOG.info("Bootstrap server {} added", dnsName);
    bootstrapsMap.put(dnsName, nodeInfo);

    updateBootstrap(nodeInfo);
  }

  /*
 * (non-Javadoc)
 *
 * @see
 * org.kaaproject.kaa.server.common.zk.operations.OperationsNodeListener
 * #onNodeAdded(org.kaaproject.kaa.server.common.zk.gen.OperationsNodeInfo)
 */
  @Override
  public void onNodeAdded(OperationsNodeInfo nodeInfo) {
    String dnsName = getNameFromConnectionInfo(nodeInfo.getConnectionInfo());
    int accessPointId = ServerNameUtil.crc32(nodeInfo.getConnectionInfo());
    addNewOperationsServer(accessPointId, dnsName, nodeInfo);

    LOG.info("Operations server [{}][{}] added. Updating {} Bootstrap servers",
        accessPointId, dnsName, bootstrapsMap.size());

    for (BootstrapNodeInfo bootstrapNodeInfo : bootstrapsMap.values()) {
      updateBootstrap(bootstrapNodeInfo);
    }
  }


  /*
   * (non-Javadoc)
   *
   * @see org.kaaproject.kaa.server.common.zk.bootstrap.BootstrapNodeListener#
   * onNodeUpdated(org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo)
   */
  @Override
  public void onNodeUpdated(BootstrapNodeInfo nodeInfo) {
    String dnsName = getNameFromConnectionInfo(nodeInfo.getConnectionInfo());
    LOG.info("Bootstrap server {} updated", dnsName);
    bootstrapsMap.put(dnsName, nodeInfo);
  }


  /*
 * (non-Javadoc)
 *
 * @see
 * org.kaaproject.kaa.server.common.zk.operations.OperationsNodeListener
 * #onNodeUpdated
 * (org.kaaproject.kaa.server.common.zk.gen.OperationsNodeInfo)
 */
  @Override
  public void onNodeUpdated(OperationsNodeInfo nodeInfo) {
    String dnsName = getNameFromConnectionInfo(nodeInfo.getConnectionInfo());
    int accessPointId = ServerNameUtil.crc32(nodeInfo.getConnectionInfo());
    LOG.info("Operations server [{}][{}] updated", accessPointId, dnsName);
    if (opsServersMap.containsKey(accessPointId)) {
      opsServersMap.get(accessPointId).history.addOpsServerLoad(nodeInfo.getLoadInfo());
    } else {
      addNewOperationsServer(accessPointId, dnsName, nodeInfo);
    }
  }

  /*
   * (non-Javadoc)
   *
   * @see org.kaaproject.kaa.server.common.zk.bootstrap.BootstrapNodeListener#
   * onNodeRemoved(org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo)
   */
  @Override
  public void onNodeRemoved(BootstrapNodeInfo nodeInfo) {
    String dnsName = getNameFromConnectionInfo(nodeInfo.getConnectionInfo());
    LOG.info("Bootstrap server {} removed", dnsName);
    bootstrapsMap.remove(dnsName);
  }

  /*
   * (non-Javadoc)
   *
   * @see
   * org.kaaproject.kaa.server.common.zk.operations.OperationsNodeListener
   * #onNodeRemoved
   * (org.kaaproject.kaa.server.common.zk.gen.OperationsNodeInfo)
   */
  @Override
  public void onNodeRemoved(OperationsNodeInfo nodeInfo) {
    String dnsName = getNameFromConnectionInfo(nodeInfo.getConnectionInfo());
    int accessPointId = ServerNameUtil.crc32(nodeInfo.getConnectionInfo());
    opsServersMap.remove(accessPointId);

    LOG.info("Operations server [{}][{}] removed. Updating {} Bootstrap servers",
        accessPointId, dnsName, bootstrapsMap.size());

    for (BootstrapNodeInfo bootstrapNodeInfo : bootstrapsMap.values()) {
      updateBootstrap(bootstrapNodeInfo);
    }
  }


  private void addNewOperationsServer(int accessPointId, String dnsName,
                                      OperationsNodeInfo nodeInfo) {
    OperationsServerMeta meta = new OperationsServerMeta(null, nodeInfo);
    meta.opsServer = new ThriftOperationsServer(dnsName, DEFAULT_PRIORITY);
    opsServersMap.put(accessPointId, meta);
  }



  /**
   * Gets the load distribution service.
   *
   * @return the loadDistributionService
   */
  public LoadDistributionService getLoadDistributionService() {
    return loadDistributionService;
  }

  /**
   * Sets the load distribution service.
   *
   * @param loadDistributionService the loadDistributionService to set
   */
  public void setLoadDistributionService(LoadDistributionService loadDistributionService) {
    this.loadDistributionService = loadDistributionService;
  }

  /**
   * Update bootstrap.
   *
   * @param nodeInfo the node info
   */
  private void updateBootstrap(BootstrapNodeInfo nodeInfo) {
    final String dnsName = getNameFromConnectionInfo(nodeInfo.getConnectionInfo());
    LOG.debug("Update bootstrap service: {}", dnsName);
    try {
      ThriftClient<BootstrapThriftService.Client> thriftClient = new ThriftClient<>(
          nodeInfo.getConnectionInfo().getThriftHost().toString(),
          nodeInfo.getConnectionInfo().getThriftPort(),
          KaaThriftService.BOOTSTRAP_SERVICE,
          BootstrapThriftService.Client.class
      );

      thriftClient.setThriftActivity(new ThriftActivity<BootstrapThriftService.Client>() {

        @Override
        public void isSuccess(boolean activitySuccess) {
          lastBootstrapServersUpdateFailed = !activitySuccess;
          LOG.info("Bootstrap {}: Operations services list updated {}", dnsName,
              activitySuccess ? "successfully" : "unsuccessfully");
        }

        @Override
        public void doInTemplate(Client template) {
          try { // NOSONAR
            List<ThriftOperationsServer> operationsServersList = new ArrayList<>();
            for (Integer accessPointId : opsServersMap.keySet()) {
              operationsServersList.add(opsServersMap.get(accessPointId).opsServer);
              LOG.trace("Bootstrap {} server: {}",
                  dnsName, opsServersMap.get(accessPointId).opsServer.toString());
            }
            LOG.trace("Bootstrap {} Operations servers list size {} ready to updates",
                dnsName, operationsServersList.size());
            template.onOperationsServerListUpdate(operationsServersList);
            LOG.info("Bootstrap {} Operations servers list updated.", dnsName);
          } catch (TException ex) {
            lastBootstrapServersUpdateFailed = true;
            LOG.error(format("Bootstrap  Operations servers list updated failed", dnsName), ex);
          }
        }
      });

      ThriftExecutor.execute(thriftClient);
    } catch (NoSuchMethodException
        | SecurityException
        | InstantiationException
        | IllegalAccessException
        | IllegalArgumentException
        | InvocationTargetException ex) {
      lastBootstrapServersUpdateFailed = true;
      LOG.error(format("Bootstrap {0} Operations services list execute updated failed", dnsName),
          ex);
    }
  }

  /**
   * Send redirection rule.
   *
   * @param accessPointId the access point identifier
   * @param nodeInfo      the node info
   * @param rules         the list of redirection rules
   */
  private void sendRedirectionRule(final Integer accessPointId, OperationsNodeInfo nodeInfo,
                                   final List<RedirectionRule> rules) {
    LOG.trace("Set redirection rule for Operations server: {}; Thrift: {}:{}",
        accessPointId, nodeInfo.getConnectionInfo().getThriftHost().toString(),
        nodeInfo.getConnectionInfo().getThriftPort());
    try {

      ThriftClient<OperationsThriftService.Client> thriftClient = new ThriftClient<>(
          nodeInfo.getConnectionInfo().getThriftHost().toString(),
          nodeInfo.getConnectionInfo().getThriftPort(),
          KaaThriftService.OPERATIONS_SERVICE,
          OperationsThriftService.Client.class
      );

      thriftClient.setThriftActivity(new ThriftActivity<OperationsThriftService.Client>() {

        @Override
        public void isSuccess(boolean activitySuccess) {
          LOG.info("Operations server {} redirection rule set {}", accessPointId,
              activitySuccess ? "successfully" : "unsuccessfully");
        }

        @Override
        public void doInTemplate(OperationsThriftService.Client template) {
          try { // NOSONAR
            for (RedirectionRule rule : rules) {
              template.setRedirectionRule(rule);
              LOG.info("Operations {} set redirection rule: {} <> {}, {}",
                  accessPointId, rule.getAccessPointId(), rule.getInitRedirectProbability(),
                  rule.getSessionRedirectProbability());
            }
          } catch (TException ex) {
            LOG.error(format("Operations server {0} set redirection rule failed", accessPointId),
                ex);
          }
        }
      });

      ThriftExecutor.execute(thriftClient);
    } catch (NoSuchMethodException
        | SecurityException
        | InstantiationException
        | IllegalAccessException
        | IllegalArgumentException
        | InvocationTargetException ex) {
      LOG.error(format("Operations server {0} set redirection rule failed", accessPointId), ex);
    }
  }

  /**
   * Gets the operations Server history TTL.
   *
   * @return the opsLoadHistoryTtl
   */
  public long getOpsServerHistoryTtl() {
    return opsLoadHistoryTtl;
  }

  /**
   * Sets the operations history TTL.
   *
   * @param opsServerHistoryTtl the opsLoadHistoryTtl to set
   */
  public void setOpsServerHistoryTtl(long opsServerHistoryTtl) {
    this.opsLoadHistoryTtl = opsServerHistoryTtl;
  }

  /**
   * Dynamic rebalancer getter.
   *
   * @return Rebalancer instance.
   */
  public Rebalancer getDynamicRebalancer() {
    return loadDistributionService.getRebalancer();
  }

  class OperationsServerMeta {


    public ThriftOperationsServer opsServer;


    public OperationsServerLoadHistory history;


    public OperationsNodeInfo nodeInfo;

    /**
     * The Constructor.
     *
     * @param opsServer the Operations Server
     * @param nodeInfo  the node info
     */
    public OperationsServerMeta(ThriftOperationsServer opsServer, OperationsNodeInfo nodeInfo) {
      this.opsServer = opsServer;
      this.nodeInfo = nodeInfo;
      history = new OperationsServerLoadHistory(opsLoadHistoryTtl);
      history.addOpsServerLoad(nodeInfo.getLoadInfo());
    }
  }
}
