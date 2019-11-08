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

package org.kaaproject.kaa.server.admin.client.mvp.data;

import com.google.gwt.user.client.rpc.AsyncCallback;

import org.kaaproject.avro.ui.gwt.client.widget.grid.AbstractGrid;
import org.kaaproject.kaa.common.dto.ServerProfileSchemaDto;
import org.kaaproject.kaa.server.admin.client.KaaAdmin;
import org.kaaproject.kaa.server.admin.client.mvp.activity.grid.AbstractDataProvider;
import org.kaaproject.kaa.server.admin.client.util.HasErrorMessage;

import java.util.List;

public class ServerProfileSchemasDataProvider
    extends AbstractDataProvider<ServerProfileSchemaDto, String> {

  private String applicationId;

  /**
   * All-args constructor.
   */
  public ServerProfileSchemasDataProvider(AbstractGrid<ServerProfileSchemaDto, String> dataGrid,
                                          HasErrorMessage hasErrorMessage,
                                          String applicationId) {
    super(dataGrid, hasErrorMessage, false);
    this.applicationId = applicationId;
    addDataDisplay();
  }

  @Override
  protected void loadData(final LoadCallback callback) {
    KaaAdmin.getDataSource().loadServerProfileSchemas(
        applicationId, new AsyncCallback<List<ServerProfileSchemaDto>>() {
          @Override
          public void onFailure(Throwable caught) {
            callback.onFailure(caught);

          }

          @Override
          public void onSuccess(List<ServerProfileSchemaDto> result) {
            callback.onSuccess(result);
          }
        });
  }
}
