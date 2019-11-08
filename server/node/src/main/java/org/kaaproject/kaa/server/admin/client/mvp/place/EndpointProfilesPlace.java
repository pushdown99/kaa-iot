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

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

import org.kaaproject.kaa.server.admin.client.util.Utils;

public class EndpointProfilesPlace extends TreePlace {

  protected String applicationId;

  public EndpointProfilesPlace(String applicationId) {
    this.applicationId = applicationId;
  }

  public String getApplicationId() {
    return applicationId;
  }

  @Override
  public String getName() {
    return Utils.constants.endpointProfiles();
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
    EndpointProfilesPlace other = (EndpointProfilesPlace) obj;
    if (applicationId == null) {
      if (other.applicationId != null) {
        return false;
      }
    } else if (!applicationId.equals(other.applicationId)) {
      return false;
    }
    return true;
  }

  @Override
  public boolean isLeaf() {
    return true;
  }

  @Override
  public TreePlace createDefaultPreviousPlace() {
    return new ApplicationPlace(applicationId);
  }

  @Prefix(value = "endProfile")
  public static class Tokenizer implements PlaceTokenizer<EndpointProfilesPlace>, PlaceConstants {

    @Override
    public String getToken(EndpointProfilesPlace place) {
      PlaceParams.clear();
      PlaceParams.putParam(APPLICATION_ID, place.getApplicationId());
      return PlaceParams.generateToken();
    }

    @Override
    public EndpointProfilesPlace getPlace(String token) {
      PlaceParams.paramsFromToken(token);
      return new EndpointProfilesPlace(PlaceParams.getParam(APPLICATION_ID));
    }
  }
}
