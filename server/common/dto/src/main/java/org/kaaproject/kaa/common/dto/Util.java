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

package org.kaaproject.kaa.common.dto;

import java.util.Arrays;

public class Util {

  private Util() {
  }

  /**
   * Copies an array.
   *
   * @param array array
   * @return      array copy
   */
  public static byte[] getArrayCopy(byte[] array) {
    byte[] bytes = null;
    if (array != null) {
      bytes = Arrays.copyOf(array, array.length);
    }
    return bytes;
  }
}
