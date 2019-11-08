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

package org.kaaproject.kaa.server.admin.client.mvp.place;

import com.google.gwt.place.shared.Prefix;

import org.kaaproject.kaa.server.admin.client.util.Utils;

public class LogAppendersPlace extends AbstractPluginsPlace {

  public LogAppendersPlace(String applicationId) {
    super(applicationId);
  }

  @Override
  public String getName() {
    return Utils.constants.logAppenders();
  }

  @Prefix(value = "logAppends")
  public static class Tokenizer extends AbstractPluginsPlace.Tokenizer<LogAppendersPlace> {

    @Override
    protected LogAppendersPlace getPlaceImpl(String applicationId) {
      return new LogAppendersPlace(applicationId);
    }
  }

}
