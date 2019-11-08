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

public class NotificationSchemaPlace extends AbstractSchemaPlaceApplication {

  public NotificationSchemaPlace(String applicationId, String schemaId) {
    super(applicationId, schemaId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    NotificationSchemaPlace other = (NotificationSchemaPlace) obj;
    if (schemaId == null) {
      if (other.schemaId != null) {
        return false;
      }
    } else if (!schemaId.equals(other.schemaId)) {
      return false;
    }
    return true;
  }

  @Override
  public String getName() {
    return Utils.constants.notificationSchema();
  }

  @Override
  public TreePlace createDefaultPreviousPlace() {
    return new NotificationSchemasPlace(applicationId);
  }

  @Prefix(value = "notifSchema")
  public static class Tokenizer
      extends AbstractSchemaPlaceApplication.Tokenizer<NotificationSchemaPlace> {

    @Override
    protected NotificationSchemaPlace getPlaceImpl(String applicationId,
                                                   String schemaId) {
      return new NotificationSchemaPlace(applicationId, schemaId);
    }
  }
}
