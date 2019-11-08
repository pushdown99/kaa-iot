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

package org.kaaproject.kaa.server.admin.client.mvp.view.verifier;

import com.google.gwt.user.cellview.client.DataGrid;

import org.kaaproject.kaa.common.dto.user.UserVerifierDto;
import org.kaaproject.kaa.server.admin.client.mvp.view.plugin.BasePluginGrid;
import org.kaaproject.kaa.server.admin.client.util.Utils;

public class UserVerifierGrid extends BasePluginGrid<UserVerifierDto> {

  public UserVerifierGrid(boolean embedded) {
    super(embedded);
  }

  @Override
  protected float constructColumnsImpl(DataGrid<UserVerifierDto> table) {
    float prefWidth = super.constructColumnsImpl(table);

    prefWidth += constructStringColumn(table, Utils.constants.verifierToken(),
        new StringValueProvider<UserVerifierDto>() {
          @Override
          public String getValue(UserVerifierDto item) {
            return item.getVerifierToken();
          }
        }, 80);
    return prefWidth;
  }

  @Override
  protected String deleteQuestion() {
    return Utils.messages.removeUserVerifierQuestion();
  }

  @Override
  protected String deleteTitle() {
    return Utils.messages.removeUserVerifierTitle();
  }

}
