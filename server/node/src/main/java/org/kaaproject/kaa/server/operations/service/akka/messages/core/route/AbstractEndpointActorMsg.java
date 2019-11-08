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

package org.kaaproject.kaa.server.operations.service.akka.messages.core.route;

public class AbstractEndpointActorMsg implements EndpointActorMsg {

  private final EndpointAddress address;
  private final ActorClassifier classifier;

  /**
   * All-args constructor.
   */
  public AbstractEndpointActorMsg(EndpointAddress address, ActorClassifier classifier) {
    super();
    this.address = address;
    this.classifier = classifier;
  }

  @Override
  public EndpointAddress getAddress() {
    return address;
  }

  @Override
  public ActorClassifier getClassifier() {
    return classifier;
  }

  @Override
  public String toString() {
    return "AbstractEndpointActorMessage [address=" + address + ", classifier=" + classifier + "]";
  }

}
