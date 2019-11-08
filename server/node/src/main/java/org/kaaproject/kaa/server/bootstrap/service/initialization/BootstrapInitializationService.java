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

package org.kaaproject.kaa.server.bootstrap.service.initialization;

import org.apache.curator.framework.CuratorFramework;
import org.kaaproject.kaa.server.bootstrap.service.OperationsServerListService;
import org.kaaproject.kaa.server.bootstrap.service.security.KeyStoreService;
import org.kaaproject.kaa.server.common.zk.bootstrap.BootstrapNode;
import org.kaaproject.kaa.server.common.zk.gen.BootstrapNodeInfo;
import org.kaaproject.kaa.server.common.zk.gen.ConnectionInfo;
import org.kaaproject.kaa.server.common.zk.gen.TransportMetaData;
import org.kaaproject.kaa.server.node.service.initialization.AbstractInitializationService;
import org.kaaproject.kaa.server.transport.TransportService;
import org.kaaproject.kaa.server.transport.TransportUpdateListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * DefaultBootstrapInitializationService Class. Starts and stops all services in
 * the Bootstrap service: 1. ZooKeeper service; 2. Netty
 * HTTP service.
 *
 * @author Andrey Panasenko
 */
@Service
public class BootstrapInitializationService extends AbstractInitializationService {

  /**
   * Constant LOG.
   */
  private static final Logger LOG = LoggerFactory.getLogger(BootstrapInitializationService.class);

  @Autowired
  private TransportService bootstrapTransportService;

  /**
   * The bootstrap node.
   */
  private BootstrapNode bootstrapNode;

  @Autowired
  private OperationsServerListService operationsServerListService;

  /**
   * The key store service.
   */
  @Autowired
  private KeyStoreService bootstrapKeyStoreService;

  @Autowired
  private CuratorFramework zkClient;

  /*
   * (non-Javadoc)
   *
   * @see org.kaaproject.kaa.server.bootstrap.service.initialization.
   * BootstrapInitializationService#start()
   */
  @Override
  public void start() {
    LOG.trace("Starting Bootstrap service..." + propertiesToString());
    try {
      LOG.trace("Bootstrap Service ZK started");
      if (operationsServerListService == null) {
        throw new Exception("Error initializing OperationsServerListService()"); // NOSONAR
      }

      bootstrapTransportService.lookupAndInit();

      if (getNodeConfig().isZkEnabled()) {
        startZk();
        operationsServerListService.init(bootstrapNode);
        bootstrapTransportService.addListener(new TransportUpdateListener() {

          @Override
          public void onTransportsStarted(List<TransportMetaData> mdList) {
            BootstrapNodeInfo info = bootstrapNode.getNodeInfo();
            info.setTransports(mdList);
            try {
              bootstrapNode.updateNodeData(info);
            } catch (IOException ex) {
              LOG.error("Failed to update bootstrap node info", ex);
            }
          }

        });
      }

      bootstrapTransportService.start();

      LOG.info("Bootstrap Service Started.");
    } catch (Exception ex) {
      LOG.error("Error starting Bootstrap Service", ex);
    }

  }

  /*
   * (non-Javadoc)
   *
   * @see org.kaaproject.kaa.server.bootstrap.service.initialization.
   * BootstrapInitializationService#stop()
   */
  @Override
  public void stop() {
    LOG.trace("Stopping Bootstrap Service..." + propertiesToString());

    if (getNodeConfig().isZkEnabled()) {
      stopZk();
    }

    if (bootstrapTransportService != null) {
      bootstrapTransportService.stop();
    }
    LOG.info("Bootstrap Service Stopped.");
  }

  /**
   * Start zk.
   *
   * @throws Exception in case of error
   */
  private void startZk() throws Exception { // NOSONAR
    if (getNodeConfig().isZkEnabled()) {
      LOG.info("Bootstrap service starting ZooKepper connection to {}",
          getNodeConfig().getZkHostPortList());
      BootstrapNodeInfo nodeInfo = new BootstrapNodeInfo();
      ByteBuffer keyData = ByteBuffer.wrap(bootstrapKeyStoreService.getPublicKey().getEncoded());
      LOG.trace("Bootstrap service: registering in ZK: thriftHost {}; "
              + "thriftPort {}; nettyHost {}; nettyPort {}",
          getNodeConfig().getThriftHost(),
          getNodeConfig().getThriftPort());
      nodeInfo.setConnectionInfo(new ConnectionInfo(
          getNodeConfig().getThriftHost(), getNodeConfig().getThriftPort(), keyData));
      nodeInfo.setTransports(new ArrayList<>());
      nodeInfo.setTimeStarted(System.currentTimeMillis());
      bootstrapNode = new BootstrapNode(nodeInfo, zkClient);
      if (bootstrapNode != null) {
        bootstrapNode.start();
      }
    }
  }

  /**
   * Stop zk.
   */
  private void stopZk() {
    try {
      if (bootstrapNode != null) {
        bootstrapNode.close();
      }
    } catch (IOException ex) {
      LOG.warn("Exception when closing ZK node", ex);
    } finally {
      bootstrapNode = null;
    }
  }

  /**
   * Return properties for printing in logs.
   *
   * @return String representation of properties
   */
  private String propertiesToString() {
    StringBuffer sb = new StringBuffer();
    sb.append("\nProperties: \n");
    sb.append("thriftHost: " + getNodeConfig().getThriftHost() + "\n");
    sb.append("thriftPort: " + getNodeConfig().getThriftPort() + "\n");
    sb.append("zkEnabled: " + getNodeConfig().isZkEnabled() + "\n");
    sb.append("zkHostPortList: " + getNodeConfig().getZkHostPortList() + "\n");
    sb.append("zkMaxRetryTime: " + getNodeConfig().getZkMaxRetryTime() + "\n");
    sb.append("zkSleepTime: " + getNodeConfig().getZkSleepTime() + "\n");
    sb.append("zkIgnoreErrors: " + getNodeConfig().isZkIgnoreErrors() + "\n");
    return sb.toString();
  }
}
