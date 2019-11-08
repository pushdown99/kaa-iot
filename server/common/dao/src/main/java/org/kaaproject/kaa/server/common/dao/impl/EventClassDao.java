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

package org.kaaproject.kaa.server.common.dao.impl;

import org.kaaproject.kaa.common.dto.event.EventClassType;

import java.util.List;

/**
 * The interface for Event Class Dao.
 *
 * @param <T> the type parameter
 */
public interface EventClassDao<T> extends SqlDao<T> {

  /**
   * Find all Event Classes by Event Class Family id.
   *
   * @param id the user id
   * @return the list of users
   */
  List<T> findByEcfvId(String id);

  /**
   * Find all Event Classes by Event Class Family id, version and type.
   *
   * @param ecfId   the ecf id
   * @param version the version
   * @param type    the type
   * @return the list of event classes
   */
  List<T> findByEcfvIdVersionAndType(String ecfId, int version, EventClassType type);

  /**
   * Remove all Event Classes by Event Class Family id.
   *
   * @param tenantId the tenant id
   */
  void removeByEcfvId(String tenantId);

  /**
   * Find Event Class by Tenant id and FQN.
   *
   * @param tenantId the tenant id
   * @param fqn      the FQN
   * @return the list of found event classes
   */
  List<T> findByTenantIdAndFqn(String tenantId, String fqn);

  /**
   * Find Event Class by Tenant id, FQN and version.
   *
   * @param tenantId the tenant id
   * @param fqn      the FQN
   * @param version  the version
   * @return the found event classes
   */
  T findByTenantIdAndFqnAndVersion(String tenantId, String fqn, int version);

}
