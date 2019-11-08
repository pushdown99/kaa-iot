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

package org.kaaproject.kaa.server.operations.service.delta;

import org.kaaproject.kaa.common.dto.EndpointProfileDto;
import org.kaaproject.kaa.server.operations.pojo.GetDeltaRequest;
import org.kaaproject.kaa.server.operations.pojo.GetDeltaResponse;
import org.kaaproject.kaa.server.operations.pojo.exceptions.GetDeltaException;
import org.kaaproject.kaa.server.operations.service.cache.ConfigurationCacheEntry;

/**
 * Service that performs delta calculation process.
 *
 * @author ashvayka
 */
public interface DeltaService {

  /**
   * Gets the delta.
   *
   * @param request the request
   * @return the delta
   * @throws GetDeltaException the get delta exception
   */
  GetDeltaResponse getDelta(GetDeltaRequest request) throws GetDeltaException;

  /**
   * Gets the up to date configuration for given endpoint profile.
   *
   * @param appToken    - the application token
   * @param endpointKey - the endpoint key
   * @param profile     - the endpoint profile
   * @return cache entry
   * @throws GetDeltaException the get delta exception
   */
  ConfigurationCacheEntry getConfiguration(
      String appToken, String endpointKey,
      EndpointProfileDto profile) throws GetDeltaException;

}
