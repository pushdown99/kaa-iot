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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import org.kaaproject.avro.ui.gwt.client.util.BusyAsyncCallback;
import org.kaaproject.kaa.common.dto.BaseSchemaDto;
import org.kaaproject.kaa.common.dto.ctl.CTLSchemaScopeDto;
import org.kaaproject.kaa.server.admin.client.KaaAdmin;
import org.kaaproject.kaa.server.admin.client.mvp.ClientFactory;
import org.kaaproject.kaa.server.admin.client.mvp.place.AbstractSchemaPlaceEvent;
import org.kaaproject.kaa.server.admin.client.mvp.place.CtlSchemaPlace;
import org.kaaproject.kaa.server.admin.client.mvp.view.BaseCtlSchemaView;
import org.kaaproject.kaa.server.admin.client.mvp.view.widget.RecordPanel.FormDataLoader;
import org.kaaproject.kaa.server.admin.client.util.ErrorMessageCustomizer;
import org.kaaproject.kaa.server.admin.client.util.Utils;
import org.kaaproject.kaa.server.admin.shared.schema.BaseSchemaViewDto;
import org.kaaproject.kaa.server.admin.shared.schema.CtlSchemaReferenceDto;

import java.util.List;

public abstract class AbstractBaseCtlSchemaActivityEvent<S extends BaseSchemaDto,
    T extends BaseSchemaViewDto<S>,
    V extends BaseCtlSchemaView,
    P extends AbstractSchemaPlaceEvent>
    extends AbstractBaseCtlSchemaActivity<S, T, V, P>
    implements ErrorMessageCustomizer, FormDataLoader {

  protected String ecfId;
  protected String ecfVersionId;
  protected int ecfVersion;

  public AbstractBaseCtlSchemaActivityEvent(P place, ClientFactory clientFactory) {
    super(place, clientFactory);
  }

  @Override
  protected T newEntity() {
    T schema = newSchema();
    return schema;
  }

  @Override
  protected String getEntityId(P place) {
    return place.getSchemaId();
  }

  @Override
  protected void onEntityRetrieved() {
    if (create) {
      registrations.add(detailsView.getNewCtlButton().addClickHandler(new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
          CtlSchemaPlace newCtlPlace = null;

          newCtlPlace = new CtlSchemaPlace("", null, CTLSchemaScopeDto.TENANT, place.getEcfId(),
              place.getEcfVersionId(), place.getEcfVersion(), true, true);
          newCtlPlace.setSchemaType(getPlaceSchemaType());
          newCtlPlace.setPreviousPlace(place);
          canceled = true;
          goTo(newCtlPlace);

        }
      }));

      KaaAdmin.getDataSource().getTenantLevelCtlSchemaReferenceForEcf(place.getEcfId(),
          place.getEventClassDtoList(), new BusyAsyncCallback<List<CtlSchemaReferenceDto>>() {
            @Override
            public void onFailureImpl(Throwable caught) {
              Utils.handleException(caught, detailsView);
            }

            @Override
            public void onSuccessImpl(List<CtlSchemaReferenceDto> result) {
              detailsView.getCtlSchemaReference().setAcceptableValues(result);
              bindDetailsView(true);
            }
          });
      detailsView.getSchemaForm().setFormDataLoader(this);
    } else {
      bindDetailsView(false);
    }
  }
}
