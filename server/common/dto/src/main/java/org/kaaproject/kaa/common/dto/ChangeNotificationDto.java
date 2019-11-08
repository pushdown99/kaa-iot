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


import java.io.Serializable;

public class ChangeNotificationDto implements Serializable {

  private static final long serialVersionUID = 5138324914078714719L;

  private String appId;
  private int appSeqNumber;
  private String groupId;
  private int groupSeqNumber;

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public int getAppSeqNumber() {
    return appSeqNumber;
  }

  public void setAppSeqNumber(int appSeqNumber) {
    this.appSeqNumber = appSeqNumber;
  }

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public int getGroupSeqNumber() {
    return groupSeqNumber;
  }

  public void setGroupSeqNumber(int groupSeqNumber) {
    this.groupSeqNumber = groupSeqNumber;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof ChangeNotificationDto)) {
      return false;
    }

    ChangeNotificationDto that = (ChangeNotificationDto) obj;

    if (appSeqNumber != that.appSeqNumber) {
      return false;
    }
    if (groupSeqNumber != that.groupSeqNumber) {
      return false;
    }
    if (appId != null ? !appId.equals(that.appId) : that.appId != null) {
      return false;
    }
    if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = appId != null ? appId.hashCode() : 0;
    result = 31 * result + appSeqNumber;
    result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
    result = 31 * result + groupSeqNumber;
    return result;
  }

  @Override
  public String toString() {
    return "ChangeNotificationDto{"
           + "appId='" + appId + '\''
           + ", appSeqNumber=" + appSeqNumber
           + ", groupId='" + groupId + '\''
           + ", groupSeqNumber=" + groupSeqNumber
           + '}';
  }
}
