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

public class ConfigurationPlace extends AbstractRecordPlace {

  private String schemaId;

  public ConfigurationPlace(String applicationId, String schemaId, String endpointGroupId,
                            boolean create, boolean showActive, double random) {
    super(applicationId, endpointGroupId, create, showActive, random);
    this.schemaId = schemaId;
  }

  public String getSchemaId() {
    return schemaId;
  }

  @Override
  public String getName() {
    return Utils.constants.configuration();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    ConfigurationPlace other = (ConfigurationPlace) obj;
    if (schemaId == null) {
      if (other.schemaId != null) {
        return false;
      }
    } else if (!schemaId.equals(other.schemaId)) {
      return false;
    }
    return true;
  }

  @Prefix(value = "config")
  public static class Tokenizer extends AbstractRecordPlace.Tokenizer<ConfigurationPlace> {

    @Override
    protected ConfigurationPlace getPlaceImpl(String applicationId, String endpointGroupId,
                                              boolean create, boolean showActive, double random) {
      return new ConfigurationPlace(
          applicationId, PlaceParams.getParam(SCHEMA_ID),
          endpointGroupId, create, showActive, random);
    }

    @Override
    protected void updateTokenImpl(ConfigurationPlace place) {
      PlaceParams.putParam(SCHEMA_ID, place.getSchemaId());
    }
  }

}
