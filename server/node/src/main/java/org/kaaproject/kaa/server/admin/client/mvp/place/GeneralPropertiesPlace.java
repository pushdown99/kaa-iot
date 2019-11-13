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

public class GeneralPropertiesPlace extends AbstractPropertiesPlace {

  public GeneralPropertiesPlace() {
  }

  @Override
  public boolean equals(Object obj) {
    return obj != null && (obj instanceof GeneralPropertiesPlace);
  }

  @Override
  public String getName() {
    return Utils.constants.generalSettings();
  }

  @Prefix(value = "genProps")
  public static class Tokenizer extends AbstractPropertiesPlace.Tokenizer<GeneralPropertiesPlace> {
    @Override
    public GeneralPropertiesPlace getPlace(String token) {
      return new GeneralPropertiesPlace();
    }
  }
}
