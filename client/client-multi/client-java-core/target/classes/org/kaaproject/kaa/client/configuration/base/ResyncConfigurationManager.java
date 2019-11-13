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

package org.kaaproject.kaa.client.configuration.base;

import org.kaaproject.kaa.client.KaaClientProperties;
import org.kaaproject.kaa.client.context.ExecutorContext;
import org.kaaproject.kaa.client.persistence.KaaClientState;
import org.kaaproject.kaa.schema.base.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Generated;

@Generated("ResyncConfigurationManager.java.template")
public class ResyncConfigurationManager extends AbstractConfigurationManager
        implements ConfigurationManager {

  private static final Logger LOG = LoggerFactory.getLogger(ResyncConfigurationManager.class);

  public ResyncConfigurationManager(KaaClientProperties properties, KaaClientState state,
                                    ExecutorContext executorContext) {
    super(properties, state, executorContext);
  }

  @Override
  public Configuration getConfiguration() {
    try {
      return deserializer.fromByteArray(getConfigurationData());
    } catch (IOException ex) {
      LOG.error("Failed to decode configuration data {}, exception catched: {}",
              Arrays.toString(getConfigurationData()), ex);
      try {
        return deserializer.fromByteArray(getDefaultConfigurationData());
      } catch (IOException e1) {
        LOG.error("Failed to decode default configuration data {}, exception catched: {}",
                Arrays.toString(getConfigurationData()), e1);
        return null;
      }
    }
  }
}
