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

package org.kaaproject.kaa.server.operations.service.akka.messages.core.stats;

public class StatusRequestState {

  private final StatusRequestMessage originator;
  private int pendingResponses;
  private int endpontCount;

  /**
   * All-args constructor.
   */
  public StatusRequestState(StatusRequestMessage originator, int pendingResponses) {
    super();
    this.originator = originator;
    this.pendingResponses = pendingResponses;
  }

  /**
   * Process an actor status response.
   *
   * @param response actor status response to be processed
   * @return         true if all pending responses are processed otherwise false
   */
  public boolean processResponse(ActorStatusResponse response) {
    endpontCount += response.getEndpointCount();
    pendingResponses--;
    return pendingResponses == 0;
  }

  public int getEndpontCount() {
    return endpontCount;
  }

  public StatusRequestMessage getOriginator() {
    return originator;
  }
}
