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

public class ChangeProfileFilterNotification implements Serializable {

  private static final long serialVersionUID = -8921151682547113023L;

  private ProfileFilterDto profileFilterDto;

  private ChangeNotificationDto changeNotificationDto;

  public ProfileFilterDto getProfileFilterDto() {
    return profileFilterDto;
  }

  public void setProfileFilterDto(ProfileFilterDto profileFilterDto) {
    this.profileFilterDto = profileFilterDto;
  }

  public ChangeNotificationDto getChangeNotificationDto() {
    return changeNotificationDto;
  }

  public void setChangeNotificationDto(ChangeNotificationDto changeNotificationDto) {
    this.changeNotificationDto = changeNotificationDto;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof ChangeProfileFilterNotification)) {
      return false;
    }
    ChangeProfileFilterNotification that = (ChangeProfileFilterNotification) obj;
    if (changeNotificationDto != null ? !changeNotificationDto.equals(that.changeNotificationDto) :
            that.changeNotificationDto != null) {
      return false;
    }
    if (profileFilterDto != null ? !profileFilterDto.equals(that.profileFilterDto) :
            that.profileFilterDto != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = profileFilterDto != null ? profileFilterDto.hashCode() : 0;
    result = 31 * result + (changeNotificationDto != null ? changeNotificationDto.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ChangeProfileNotification{"
           + "profileFilterDto=" + profileFilterDto
           + ", changeNotificationDto=" + changeNotificationDto
           + '}';
  }
}
