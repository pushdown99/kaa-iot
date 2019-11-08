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

package org.kaaproject.kaa.common.dto;


public class NotificationSchemaDto extends BaseSchemaDto {

  private static final long serialVersionUID = -2514664251184915862L;

  private NotificationTypeDto type;

  public NotificationTypeDto getType() {
    return type;
  }

  public void setType(NotificationTypeDto type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof NotificationSchemaDto)) {
      return false;
    }

    NotificationSchemaDto that = (NotificationSchemaDto) obj;

    if (version != that.version) {
      return false;
    }
    if (applicationId != null ? !applicationId.equals(that.applicationId) :
            that.applicationId != null) {
      return false;
    }
    if (ctlSchemaId != null ? !ctlSchemaId.equals(that.ctlSchemaId) : that.ctlSchemaId != null) {
      return false;
    }
    if (type != that.type) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = applicationId != null ? applicationId.hashCode() : 0;
    result = 31 * result + version;
    result = 31 * result + (type != null ? type.hashCode() : 0);
    result = 31 * result + (ctlSchemaId != null ? ctlSchemaId.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "NotificationSchemaDto{"
           + "id='" + id + '\''
           + ", applicationId='" + applicationId + '\''
           + ", majorVersion=" + version
           + ", type=" + type
           + ", ctlSchemaId='" + ctlSchemaId + '\''
           + '}';
  }

  public int incrementVersion() {
    return ++version;
  }
}
