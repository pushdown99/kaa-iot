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

package org.kaaproject.kaa.server.common.zk.control;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException.NodeExistsException;
import org.kaaproject.kaa.server.common.zk.ControlNodeTracker;
import org.kaaproject.kaa.server.common.zk.WorkerNodeTracker;
import org.kaaproject.kaa.server.common.zk.gen.ControlNodeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


/**
 * The Class ControlNode.
 */
public class ControlNode extends WorkerNodeTracker {

  /**
   * The Constant LOG.
   */
  private static final Logger LOG = LoggerFactory
      .getLogger(ControlNode.class);

  /**
   * The current node info.
   */
  private ControlNodeInfo currentNodeInfo;

  /**
   * Instantiates a new control node.
   *
   * @param currentNodeInfo the current node info
   */
  public ControlNode(ControlNodeInfo currentNodeInfo) {
    super();
    this.currentNodeInfo = currentNodeInfo;
  }

  /**
   * Instantiates a new control node.
   *
   * @param currentNodeInfo the current node info
   * @param zkClient        Zookeeper client
   */
  public ControlNode(ControlNodeInfo currentNodeInfo, CuratorFramework zkClient) {
    super(zkClient);
    this.currentNodeInfo = currentNodeInfo;
  }

  /**
   * Updates current node data. In case this is master node - will also update
   * ZK node; Although it is possible that we will have race condition here, i
   * expect possibility is quite low and can be ignored in first releases.
   *
   * @param currentNodeInfo the current node info
   * @throws IOException Signals that an I/O exception has occurred.
   */
  public void updateNodeData(final ControlNodeInfo currentNodeInfo) throws IOException {
    this.currentNodeInfo = currentNodeInfo;
    if (isMaster()) {
      doZkClientAction(new ZkClientAction() {
        @Override
        public void doWithZkClient(CuratorFramework client) throws Exception {
          client.setData().forPath(ControlNodeTracker.CONTROL_SERVER_NODE_PATH,
                  controlNodeAvroConverter.get().toByteArray(currentNodeInfo));
        }
      }, true);
    }
  }

  /**
   * Checks if is master.
   *
   * @return true, if is master
   */
  public boolean isMaster() {
    ControlNodeInfo serverInfo = getControlServerInfo();
    if (currentNodeInfo != null && serverInfo != null) {
      String curHost = currentNodeInfo.getConnectionInfo().getThriftHost().toString();
      int curPort = currentNodeInfo.getConnectionInfo().getThriftPort();
      String masterHost = serverInfo.getConnectionInfo().getThriftHost().toString();
      int masterPort = serverInfo.getConnectionInfo().getThriftPort();
      return curHost.equals(masterHost) && curPort == masterPort;
    } else {
      return false;
    }
  }

  /**
   * Gets the current node info.
   *
   * @return the current node info
   */
  public ControlNodeInfo getCurrentNodeInfo() {
    return currentNodeInfo;
  }

  @Override
  public boolean createZkNode() throws IOException {
    try {
      nodePath = zkClient.create().withMode(CreateMode.EPHEMERAL)
          .forPath(ControlNodeTracker.CONTROL_SERVER_NODE_PATH,
                  controlNodeAvroConverter.get().toByteArray(currentNodeInfo));
      LOG.info("Created node with path: " + nodePath);
    } catch (NodeExistsException ex) {
      LOG.info("master already exists ", ex);
    } catch (Exception ex) {
      LOG.error("Unknown Error", ex);
      close();
      throw new IOException(ex);
    }
    return true;
  }

  /*
   * (non-Javadoc)
   *
   * @see org.kaaproject.kaa.server.common.zk.ControlNodeTracker#onNoMaster()
   */
  @Override
  protected void onNoMaster() throws IOException {
    super.onNoMaster();
    createZkNode();
  }
}
