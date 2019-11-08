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

package org.kaaproject.kaa.server.control.service.sdk.compiler;

import java.net.URI;
import java.net.URISyntaxException;

import javax.tools.JavaFileObject.Kind;

/**
 * The Enum JavaDynamicUtils.
 */
public enum JavaDynamicUtils {

  /**
   * The instance.
   */
  INSTANCE;

  /**
   * Creates the uri.
   *
   * @param str the str
   * @return the uri
   */
  public URI createUri(String str) {
    try {
      return new URI(str);
    } catch (URISyntaxException ex) {
      throw new RuntimeException(ex); //NOSONAR
    }
  }

  /**
   * Gets the class name with ext.
   *
   * @param className the class name
   * @return the class name with ext
   */
  public String getClassNameWithExt(String className) {
    return className + Kind.SOURCE.extension;
  }

}
