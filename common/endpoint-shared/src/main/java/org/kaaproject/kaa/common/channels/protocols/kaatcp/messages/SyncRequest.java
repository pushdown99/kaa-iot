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

package org.kaaproject.kaa.common.channels.protocols.kaatcp.messages;

import org.kaaproject.kaa.common.channels.protocols.kaatcp.KaaTcpProtocolException;

/**
 * SyncRequest Class.
 * Extend Sync and set request flag to true.
 *
 * @author Andrey Panasenko
 */
public class SyncRequest extends Sync {

  /**
   * Instantiates a new SyncRequest.
   *
   * @param avroObject the avro object
   * @param isZipped   the is zipped
   * @param isEcrypted the is ecrypted
   */
  public SyncRequest(byte[] avroObject, boolean isZipped, boolean isEcrypted) {
    super(true, avroObject, isZipped, isEcrypted);
  }

  /**
   * Constructor used to migrate from KaaSync after Variable Header decode.
   *
   * @param old KaaSync object which used to create new
   * @throws KaaTcpProtocolException the kaa tcp protocol exception
   */
  public SyncRequest(KaaSync old) throws KaaTcpProtocolException {
    super(old);
    setRequest(true);
    decodeAvroObject();
  }

  /**
   * Default constructor.
   */
  public SyncRequest() {
    super();
    setRequest(true);
  }

}
