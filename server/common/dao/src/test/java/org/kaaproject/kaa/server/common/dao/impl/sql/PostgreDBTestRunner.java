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

package org.kaaproject.kaa.server.common.dao.impl.sql;

import org.kaaproject.kaa.server.common.dao.DBTestRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgreDBTestRunner extends DBTestRunner {

  @Override
  protected PreparedStatement prepareStatement(Connection connection) throws SQLException {
    return connection.prepareStatement("SELECT tablename FROM pg_tables where schemaname = 'public'");
  }

  @Override
  protected String getTrancateSql() {
    return new StringBuilder("TRUNCATE TABLE ").append(FORMATER).append(" CASCADE").toString();
  }

}
