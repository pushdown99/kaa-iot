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

package org.kaaproject.kaa.common.hash;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * The Class Sha1HashUtils.
 */
public abstract class Sha1HashUtils {
  protected static final Logger LOG = LoggerFactory.getLogger(Sha1HashUtils.class); //NOSONAR
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  /**
   * The Constant digest.
   */
  private static final ThreadLocal<MessageDigest> DIGEST = new ThreadLocal<MessageDigest>() {
    @Override
    protected MessageDigest initialValue() {
      return forAlgorithm("SHA-1");
    }
  };

  private Sha1HashUtils() {
  }

  static MessageDigest forAlgorithm(String algorithm) {
    try {
      return MessageDigest.getInstance(algorithm);
    } catch (NoSuchAlgorithmException ex) {
      LOG.error("No such algorithm: {}, exception catched: {}", algorithm, ex);
      return null;
    }
  }

  /**
   * Hash to bytes.
   *
   * @param data the data
   * @return the byte[]
   */
  public static byte[] hashToBytes(String data) {
    return hashToBytes(data.getBytes(UTF_8));
  }

  /**
   * Hash to bytes.
   *
   * @param bytes the bytes
   * @return the byte[]
   */
  public static byte[] hashToBytes(byte[] bytes) {
    return DIGEST.get().digest(bytes);
  }
}
