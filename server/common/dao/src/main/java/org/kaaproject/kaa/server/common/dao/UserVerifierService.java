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

/*

 * Copyright 2014 CyberVision, Inc.
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

package org.kaaproject.kaa.server.common.dao;

import org.kaaproject.kaa.common.dto.user.UserVerifierDto;

import java.util.List;

public interface UserVerifierService {

  /**
   * @param appId the app id.
   * @return the list user verifier dto
   */
  List<UserVerifierDto> findUserVerifiersByAppId(String appId);

  /**
   * @param appId         the app id.
   * @param verifierToken the verifier token
   * @return the user verifier dto
   */
  UserVerifierDto findUserVerifiersByAppIdAndVerifierToken(String appId, String verifierToken);

  /**
   * @param id the id.
   * @return the user verifier dto
   */
  UserVerifierDto findUserVerifierById(String id);

  /**
   * @param logAppenderDto the log appender dto.
   * @return the user verifier dto
   */
  UserVerifierDto saveUserVerifier(UserVerifierDto logAppenderDto);

  /**
   * @param id the id.
   */
  void removeUserVerifierById(String id);

}
