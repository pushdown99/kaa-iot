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

import org.kaaproject.avro.ui.gwt.client.widget.grid.AbstractGrid;
import org.kaaproject.kaa.common.dto.ctl.CTLSchemaScopeDto;
import org.kaaproject.kaa.common.dto.ctl.CtlSchemaMetaInfoDto;
import org.kaaproject.kaa.server.admin.client.mvp.ClientFactory;
import org.kaaproject.kaa.server.admin.client.mvp.activity.grid.AbstractDataProvider;
import org.kaaproject.kaa.server.admin.client.mvp.data.TenantCtlSchemasDataProvider;
import org.kaaproject.kaa.server.admin.client.mvp.place.CtlSchemaPlace;
import org.kaaproject.kaa.server.admin.client.mvp.place.TenantCtlSchemasPlace;
import org.kaaproject.kaa.server.admin.client.mvp.view.CtlSchemasView;

import java.util.Collections;

public class TenantCtlSchemasActivity extends CtlSchemasActivity<TenantCtlSchemasPlace> {

  public TenantCtlSchemasActivity(TenantCtlSchemasPlace place, ClientFactory clientFactory) {
    super(place, CtlSchemaMetaInfoDto.class, clientFactory);
  }

  @Override
  protected CtlSchemasView getView() {
    return clientFactory.getTenantCtlSchemasView();
  }

  @Override
  protected AbstractDataProvider<CtlSchemaMetaInfoDto, String> getDataProvider(
      AbstractGrid<CtlSchemaMetaInfoDto, String> dataGrid) {
    return new TenantCtlSchemasDataProvider(dataGrid, listView);
  }

  @Override
  protected Place newEntityPlace() {
    return new CtlSchemaPlace("", null, getCurrentScope(), null, true, true);
  }

  @Override
  protected Place existingEntityPlace(String id) {
    CtlSchemaMetaInfoDto schema = dataProvider.getRowData(id);
    return new CtlSchemaPlace(id, Collections.max(schema.getVersions()), schema.getScope(), null,
        schema.getScope() == getCurrentScope(), false);
  }

  @Override
  protected CTLSchemaScopeDto getCurrentScope() {
    return CTLSchemaScopeDto.TENANT;
  }

}
