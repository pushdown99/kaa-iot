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

import static org.kaaproject.kaa.server.admin.client.util.Utils.isNotBlank;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;

import org.kaaproject.avro.ui.gwt.client.widget.grid.AbstractGrid;
import org.kaaproject.kaa.common.dto.EndpointProfileDto;
import org.kaaproject.kaa.common.dto.EndpointProfilesPageDto;
import org.kaaproject.kaa.server.admin.client.KaaAdmin;
import org.kaaproject.kaa.server.admin.client.mvp.activity.grid.AbstractDataProvider;
import org.kaaproject.kaa.server.admin.client.util.HasErrorMessage;
import org.kaaproject.kaa.server.admin.shared.services.KaaAdminServiceException;
import org.kaaproject.kaa.server.admin.shared.services.ServiceErrorCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EndpointProfileDataProvider extends AbstractDataProvider<EndpointProfileDto, String> {

  public static final String DEFAULT_OFFSET = "0";
  private String limit = "11";
  private String offset = DEFAULT_OFFSET;
  private String applicationId;
  private String groupId;
  private String endpointKeyHash;
  private List<EndpointProfileDto> endpointProfilesList;
  private int previousStart = -1;
  private AbstractGrid<EndpointProfileDto, String> dataGrid;

  /**
   * All-args constructor.
   */
  public EndpointProfileDataProvider(AbstractGrid<EndpointProfileDto, String> dataGrid,
                                     HasErrorMessage hasErrorMessage, String applicationId) {
    super(dataGrid, hasErrorMessage, true);
    this.dataGrid = dataGrid;
    this.applicationId = applicationId;
    this.groupId = "";
    endpointProfilesList = new ArrayList<>();
    limit = String.valueOf(dataGrid.getPageSize() + 1);
  }

  @Override
  protected void onRangeChanged(HasData<EndpointProfileDto> display) {
    if ((endpointKeyHash != null && !endpointKeyHash.isEmpty())
        || (groupId != null && !groupId.isEmpty())) {
      int start = display.getVisibleRange().getStart();
      if (previousStart < start) {
        previousStart = start;
        setLoaded(false);
      }
      super.onRangeChanged(display);
    }
  }

  @Override
  protected void loadData(final LoadCallback callback) {
    if (isNotBlank(endpointKeyHash)) {
      KaaAdmin.getDataSource()
          .getEndpointProfileByKeyHash(endpointKeyHash, new AsyncCallback<EndpointProfileDto>() {
            @Override
            public void onFailure(Throwable caught) {
              if (caught instanceof KaaAdminServiceException) {
                if (((KaaAdminServiceException) caught)
                    .getErrorCode() == ServiceErrorCode.ITEM_NOT_FOUND) {
                  endpointProfilesList.clear();
                  callback.onSuccess(endpointProfilesList);
                }
              } else {
                callback.onFailure(caught);
              }
            }

            @Override
            public void onSuccess(EndpointProfileDto endpointProfileDto) {
              List<EndpointProfileDto> result = new ArrayList<>();
              if (endpointProfileDto.getApplicationId().equals(applicationId)) {
                result.add(endpointProfileDto);
              }
              endpointProfilesList.clear();
              endpointProfilesList.addAll(result);
              callback.onSuccess(endpointProfilesList);
            }
          });
    } else {
      KaaAdmin.getDataSource().getEndpointProfileByGroupId(groupId, limit, offset,
          new AsyncCallback<EndpointProfilesPageDto>() {
            @Override
            public void onFailure(Throwable caught) {
              if (caught instanceof KaaAdminServiceException) {
                if (((KaaAdminServiceException) caught)
                    .getErrorCode() == ServiceErrorCode.ITEM_NOT_FOUND) {
                  endpointProfilesList.clear();
                  callback.onSuccess(endpointProfilesList);
                }
              } else {
                callback.onFailure(caught);
              }
            }

            @Override
            public void onSuccess(EndpointProfilesPageDto result) {
              Set<EndpointProfileDto> hs = new HashSet<>();
              hs.addAll(result.getEndpointProfiles());
              hs.addAll(endpointProfilesList);
              endpointProfilesList.clear();
              endpointProfilesList.addAll(hs);
              callback.onSuccess(endpointProfilesList);
              offset = result.getPageLinkDto().getOffset();
            }
          });
    }
  }

  public void setNewGroup(String groupId) {
    this.groupId = groupId;
    this.endpointKeyHash = "";
  }

  public void setEndpointKeyHash(String endpointKeyHash) {
    this.endpointKeyHash = endpointKeyHash;
  }

  /**
   * Updates endpoint profile data.
   */
  public void update() {
    reset();
    dataGrid.getDataGrid().setVisibleRangeAndClearData(
        new Range(0, dataGrid.getPageSize()), true);
  }

  private void reset() {
    endpointProfilesList.clear();
    previousStart = -1;
    offset = DEFAULT_OFFSET;
  }
}
