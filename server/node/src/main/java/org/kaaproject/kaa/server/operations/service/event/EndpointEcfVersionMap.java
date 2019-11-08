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

package org.kaaproject.kaa.server.operations.service.event;

import org.kaaproject.kaa.common.hash.EndpointObjectHash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EndpointEcfVersionMap {

  private final Map<EndpointObjectHash, Map<String, Integer>> map;

  public EndpointEcfVersionMap() {
    super();
    map = new HashMap<EndpointObjectHash, Map<String, Integer>>();
  }

  /**
   * Puts new endpoint with specified versions to a map.
   *
   * @param endpoint endpoint
   * @param versions event class family version list
   */
  public void put(EndpointObjectHash endpoint, List<EventClassFamilyVersion> versions) {
    Map<String, Integer> innerMap = new HashMap<>();
    for (EventClassFamilyVersion ecfVersion : versions) {
      innerMap.put(ecfVersion.getEcfId(), ecfVersion.getVersion());
    }
    map.put(endpoint, innerMap);
  }

  /**
   * Returns version of specified event class family for a particular endpoint.
   *
   * @param endpoint endpoint
   * @param ecfId    event class family identifier
   * @return         version
   */
  public Integer get(EndpointObjectHash endpoint, String ecfId) {
    Map<String, Integer> ecfVersions = map.get(endpoint);
    if (ecfVersions != null) {
      return ecfVersions.get(ecfId);
    } else {
      return null;
    }
  }

  public boolean remove(EndpointObjectHash endpoint) {
    return map.remove(endpoint) != null;
  }
}
