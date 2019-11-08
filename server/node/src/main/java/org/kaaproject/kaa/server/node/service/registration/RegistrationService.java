/**
 * Copyright 2014-2016 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kaaproject.kaa.server.node.service.registration;

import org.kaaproject.kaa.common.dto.credentials.EndpointRegistrationDto;
import org.kaaproject.kaa.server.common.dao.exception.EndpointRegistrationServiceException;

import java.util.Optional;

/**
 * A service to manage endpoint registrations.
 *
 * @author Andrew Shvayka
 * @author Bohdan Khablenko
 * @since v0.9.0
 */
public interface RegistrationService {

  /**
   * Saves the given endpoint registration.
   *
   * @param endpointRegistration The endpoint registration to save
   * @return The endpoint registration saved
   * @throws EndpointRegistrationServiceException - if an exception occures.
   */
  EndpointRegistrationDto saveEndpointRegistration(EndpointRegistrationDto endpointRegistration)
          throws EndpointRegistrationServiceException;

  /**
   * Returns the endpoint registration by the endpoint ID specified.
   *
   * @param endpointId The endpoint ID
   * @return The endpoint registration found
   * @throws EndpointRegistrationServiceException - if an exception occures.
   */
  Optional<EndpointRegistrationDto> findEndpointRegistrationByEndpointId(String endpointId)
          throws EndpointRegistrationServiceException;

  /**
   * Returns the endpoint registration by the credentials ID specified.
   *
   * @param credentialsId The credentials ID
   * @return The endpoint registration found
   * @throws EndpointRegistrationServiceException - if an exception occures.
   */
  Optional<EndpointRegistrationDto> findEndpointRegistrationByCredentialsId(String credentialsId)
          throws EndpointRegistrationServiceException;

  /**
   * Removes the endpoint registration by the endpoint ID specified.
   *
   * @param endpointId The endpoint ID
   * @throws EndpointRegistrationServiceException - if an exception occures.
   */
  void removeEndpointRegistrationByEndpointId(String endpointId)
          throws EndpointRegistrationServiceException;
}
