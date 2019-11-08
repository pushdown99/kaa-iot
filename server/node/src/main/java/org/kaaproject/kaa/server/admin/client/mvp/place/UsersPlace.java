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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.HasData;
import com.google.web.bindery.event.shared.EventBus;

import org.kaaproject.kaa.common.dto.admin.UserDto;
import org.kaaproject.kaa.server.admin.client.KaaAdmin;
import org.kaaproject.kaa.server.admin.client.mvp.event.data.DataEvent;
import org.kaaproject.kaa.server.admin.client.mvp.event.data.DataEventHandler;
import org.kaaproject.kaa.server.admin.client.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class UsersPlace extends TreePlace {

  private UserPlaceDataProvider dataProvider;

  public UsersPlace() {
  }

  @Override
  public boolean equals(Object obj) {
    return obj != null && (obj instanceof UsersPlace);
  }

  @Override
  public String getName() {
    return Utils.constants.users();
  }

  @Override
  public boolean isLeaf() {
    return false;
  }

  @Override
  public TreePlaceDataProvider getDataProvider(EventBus eventBus) {
    if (dataProvider == null) {
      dataProvider = new UserPlaceDataProvider(eventBus);
    }
    return dataProvider;
  }

  @Override
  public TreePlace createDefaultPreviousPlace() {
    return null;
  }

  @Prefix(value = "users")
  public static class Tokenizer implements PlaceTokenizer<UsersPlace> {

    @Override
    public UsersPlace getPlace(String token) {
      return new UsersPlace();
    }

    @Override
    public String getToken(UsersPlace place) {
      PlaceParams.clear();
      return PlaceParams.generateToken();
    }
  }

  class UserPlaceDataProvider extends TreePlaceDataProvider implements DataEventHandler {

    UserPlaceDataProvider(EventBus eventBus) {
      eventBus.addHandler(DataEvent.getType(), this);
    }

    @Override
    public void onDataChanged(DataEvent event) {
      if (event.checkClass(UserDto.class)) {
        refresh();
      }
    }

    @Override
    protected void loadData(
        final LoadCallback callback,
        final HasData<TreePlace> display) {
      KaaAdmin.getDataSource().loadUsers(new AsyncCallback<List<UserDto>>() {
        @Override
        public void onFailure(Throwable caught) {
          callback.onFailure(caught);

        }

        @Override
        public void onSuccess(List<UserDto> result) {

          callback.onSuccess(toPlaces(result), display);
        }
      });
    }

    private List<TreePlace> toPlaces(List<UserDto> users) {
      List<TreePlace> result = new ArrayList<TreePlace>();
      for (UserDto user : users) {
        UserPlace place = new UserPlace(user.getId());
        place.setUserName(user.getUsername());
        result.add(place);
      }
      return result;
    }


  }

}
