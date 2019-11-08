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

package org.kaaproject.kaa.client.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class SingleThreadExecutorContext extends AbstractExecutorContext implements
        ExecutorContext {
  private static final Logger LOG = LoggerFactory.getLogger(SingleThreadExecutorContext.class);

  private ScheduledExecutorService singleThreadExecutor;

  public SingleThreadExecutorContext() {
    super();
  }

  @Override
  public void init() {
    LOG.debug("Creating executor service");
    singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
    LOG.debug("Created executor service");
  }

  @Override
  public void stop() {
    shutdownExecutor(singleThreadExecutor);
  }

  @Override
  public ExecutorService getLifeCycleExecutor() {
    return getSingleThreadExecutor();
  }

  @Override
  public ExecutorService getApiExecutor() {
    return getSingleThreadExecutor();
  }

  @Override
  public ExecutorService getCallbackExecutor() {
    return getSingleThreadExecutor();
  }

  @Override
  public ScheduledExecutorService getScheduledExecutor() {
    return getSingleThreadExecutor();
  }

  private ScheduledExecutorService getSingleThreadExecutor() {
    return singleThreadExecutor;
  }
}
