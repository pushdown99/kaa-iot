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

package org.kaaproject.kaa.server.admin.client.mvp.view.ctl;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.cellview.client.DataGrid;

import org.kaaproject.kaa.common.dto.ctl.CtlSchemaMetaInfoDto;
import org.kaaproject.kaa.server.admin.client.mvp.view.grid.AbstractKaaGrid;
import org.kaaproject.kaa.server.admin.client.util.Utils;

import java.util.Collections;
import java.util.Comparator;

public class CtlGrid extends AbstractKaaGrid<CtlSchemaMetaInfoDto, String> {

  private static final int DEFAULT_PAGE_SIZE = 12;

  public CtlGrid(Unit unit) {
    super(unit, false, DEFAULT_PAGE_SIZE);
  }

  @Override
  protected float constructColumnsImpl(DataGrid<CtlSchemaMetaInfoDto> table) {
    float prefWidth = 0;

    prefWidth += constructStringColumn(table,
        Utils.constants.fqn(),
        new StringValueProvider<CtlSchemaMetaInfoDto>() {
          @Override
          public String getValue(CtlSchemaMetaInfoDto item) {
            return item.getFqn();
          }
        },
        new Comparator<CtlSchemaMetaInfoDto>() {
          @Override
          public int compare(CtlSchemaMetaInfoDto o1, CtlSchemaMetaInfoDto o2) {
            return o1.getFqn().compareTo(o2.getFqn());
          }
        },
        Boolean.TRUE,
        true,
        200);

    prefWidth += constructStringColumn(table,
        Utils.constants.scope(),
        new StringValueProvider<CtlSchemaMetaInfoDto>() {
          @Override
          public String getValue(CtlSchemaMetaInfoDto item) {
            return Utils.getCtlScopeString(item.getScope());
          }
        },
        new Comparator<CtlSchemaMetaInfoDto>() {
          @Override
          public int compare(CtlSchemaMetaInfoDto o1, CtlSchemaMetaInfoDto o2) {
            return Utils.getCtlScopeString(o1.getScope()).compareTo(
                Utils.getCtlScopeString(o2.getScope()));
          }
        },
        Boolean.TRUE,
        true,
        40);

    prefWidth += constructStringColumn(table,
        Utils.constants.versionsCount(),
        new StringValueProvider<CtlSchemaMetaInfoDto>() {
          @Override
          public String getValue(CtlSchemaMetaInfoDto item) {
            return item.getVersions().size() + "";
          }
        },
        new Comparator<CtlSchemaMetaInfoDto>() {
          @Override
          public int compare(CtlSchemaMetaInfoDto o1, CtlSchemaMetaInfoDto o2) {
            return o1.getVersions().size() - o2.getVersions().size();
          }
        },
        Boolean.TRUE,
        false,
        40);

    prefWidth += constructStringColumn(table,
        Utils.constants.maxVersion(),
        new StringValueProvider<CtlSchemaMetaInfoDto>() {
          @Override
          public String getValue(CtlSchemaMetaInfoDto item) {
            return Collections.max(item.getVersions()) + "";
          }
        },
        new Comparator<CtlSchemaMetaInfoDto>() {
          @Override
          public int compare(CtlSchemaMetaInfoDto o1, CtlSchemaMetaInfoDto o2) {
            return Collections.max(o1.getVersions()) - Collections.max(o2.getVersions());
          }
        },
        Boolean.TRUE,
        false,
        40);

    return prefWidth;
  }

}
