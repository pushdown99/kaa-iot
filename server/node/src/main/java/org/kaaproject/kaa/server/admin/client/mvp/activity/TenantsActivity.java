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

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;

import org.kaaproject.avro.ui.gwt.client.widget.grid.AbstractGrid;
import org.kaaproject.kaa.common.dto.TenantDto;
import org.kaaproject.kaa.server.admin.client.mvp.ClientFactory;
import org.kaaproject.kaa.server.admin.client.mvp.activity.grid.AbstractDataProvider;
import org.kaaproject.kaa.server.admin.client.mvp.data.TenantsDataProvider;
import org.kaaproject.kaa.server.admin.client.mvp.place.TenantPlace;
import org.kaaproject.kaa.server.admin.client.mvp.place.TenantsPlace;
import org.kaaproject.kaa.server.admin.client.mvp.view.BaseListView;


public class TenantsActivity extends AbstractListActivity<TenantDto, TenantsPlace> {

  public TenantsActivity(TenantsPlace place, ClientFactory clientFactory) {
    super(place, TenantDto.class, clientFactory);
  }

  @Override
  protected BaseListView<TenantDto> getView() {
    return clientFactory.getTenantsView();
  }

  @Override
  protected AbstractDataProvider<TenantDto, String> getDataProvider(
      AbstractGrid<TenantDto, String> dataGrid) {
    return new TenantsDataProvider(dataGrid, listView);
  }

  @Override
  protected Place newEntityPlace() {
    return new TenantPlace("");
  }

  @Override
  protected Place existingEntityPlace(String id) {
    return new TenantPlace(id);
  }

  @Override
  protected void deleteEntity(String id, AsyncCallback<Void> callback) {
    callback.onSuccess((Void) null);
  }

}
