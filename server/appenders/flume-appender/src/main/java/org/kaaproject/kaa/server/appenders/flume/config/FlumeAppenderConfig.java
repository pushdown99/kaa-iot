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

package org.kaaproject.kaa.server.appenders.flume.config;

import org.apache.avro.Schema;
import org.kaaproject.kaa.server.appenders.flume.config.gen.FlumeConfig;
import org.kaaproject.kaa.server.common.plugin.KaaPluginConfig;
import org.kaaproject.kaa.server.common.plugin.PluginConfig;
import org.kaaproject.kaa.server.common.plugin.PluginType;

@KaaPluginConfig(pluginType = PluginType.LOG_APPENDER)
public class FlumeAppenderConfig implements PluginConfig {

  @Override
  public String getPluginTypeName() {
    return "Flume";
  }

  @Override
  public String getPluginClassName() {
    return "org.kaaproject.kaa.server.appenders.flume.appender.FlumeLogAppender";
  }

  @Override
  public Schema getPluginConfigSchema() {
    return FlumeConfig.getClassSchema();
  }

}
