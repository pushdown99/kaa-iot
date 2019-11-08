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

package org.kaaproject.kaa.server.admin.client.mvp.view.widget;

import com.google.gwt.text.shared.Renderer;

import org.kaaproject.kaa.common.dto.event.AefMapInfoDto;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class MultiAefMapListBox extends MultiValueListBox<AefMapInfoDto> {

  public MultiAefMapListBox() {
    super(new AefMapInfoDtoRenderer());
  }

  /**
   * Reset.
   */
  public void reset() {
    List<AefMapInfoDto> emptyList = Collections.emptyList();
    setValue(null);
    setAcceptableValues(emptyList);
  }

  static class AefMapInfoDtoRenderer implements Renderer<AefMapInfoDto> {

    @Override
    public String render(AefMapInfoDto object) {
      return object != null ? (object.getEcfName() + " ver." + object.getVersion()) : "";
    }

    @Override
    public void render(AefMapInfoDto object, Appendable appendable)
        throws IOException {
      appendable.append(render(object));
    }
  }
}
