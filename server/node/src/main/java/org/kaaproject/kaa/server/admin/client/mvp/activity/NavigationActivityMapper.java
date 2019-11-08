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

package org.kaaproject.kaa.server.admin.client.mvp.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.web.bindery.event.shared.EventBus;

import org.kaaproject.kaa.server.admin.client.mvp.ClientFactory;
import org.kaaproject.kaa.server.admin.client.mvp.place.TreePlace;

public class NavigationActivityMapper implements ActivityMapper {

  private final NavigationActivity navigationActivity;

  public NavigationActivityMapper(ClientFactory clientFactory, EventBus eventBus) {
    super();
    this.navigationActivity = new NavigationActivity(clientFactory, eventBus);
  }

  @Override
  public Activity getActivity(Place place) {
    if (place instanceof TreePlace) {
      navigationActivity.onPlaceChanged((TreePlace) place);
      return navigationActivity;
    }
    return null;
  }
}
