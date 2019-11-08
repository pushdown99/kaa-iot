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

public class ServerProfileSchemaPlace extends AbstractSchemaPlaceApplication {

  public ServerProfileSchemaPlace(String applicationId, String schemaId) {
    super(applicationId, schemaId);
  }

  @Override
  public String getName() {
    return Utils.constants.serverProfileSchema();
  }

  @Override
  public TreePlace createDefaultPreviousPlace() {
    return new ServerProfileSchemasPlace(applicationId);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }

    ServerProfileSchemaPlace that = (ServerProfileSchemaPlace) object;

    return !(applicationId != null
        ? !applicationId.equals(that.applicationId)
        : that.applicationId != null);
  }

  @Override
  public int hashCode() {
    return applicationId != null ? applicationId.hashCode() : 0;
  }

  @Prefix(value = "serverProfSchema")
  public static class Tokenizer
      extends AbstractSchemaPlaceApplication.Tokenizer<ServerProfileSchemaPlace> {

    @Override
    protected ServerProfileSchemaPlace getPlaceImpl(String applicationId,
                                                    String schemaId) {
      return new ServerProfileSchemaPlace(applicationId, schemaId);
    }
  }
}
