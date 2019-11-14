package org.kaaproject.kaa.server.appenders.maria.appender;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.kaaproject.kaa.common.dto.logs.LogEventDto;
import org.kaaproject.kaa.server.appenders.maria.config.gen.MariaDbConfig;
import org.kaaproject.kaa.server.appenders.maria.config.gen.MariaDbServer;
import org.kaaproject.kaa.server.common.log.shared.appender.data.ProfileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LogEventMariaDao implements LogEventDao {

  private static final Logger LOG = LoggerFactory.getLogger(LogEventMariaDao.class);
  private String url = "jdbc:mariadb://";
  private String fields = "";
  private Connection conn = null;

  /**
   * Create new instance of <code>LogEventMariaDao</code> using configuration instance of
   * <code>MariaDbConfig</code>.
   *
   * @param configuration the configuration of log event maria dao, it contain server size,
   *                      credentials, max wait time, etc.
   */
  @SuppressWarnings("deprecation")
  public LogEventMariaDao(MariaDbConfig configuration) throws Exception {
    for (int i = 0; i < configuration.getMariaServers().size(); i++) {
      url += ((i == 0) ? "" : ",") + configuration.getMariaServers().get(i).get("host") + ":" + configuration.getMariaServers().get(i).get("port");
    }
    url += "/" + configuration.getDbname();

    try {
      conn = DriverManager.getConnection(url, configuration.getUser(), configuration.getPassword());
      LOG.debug("[MYSQL] getConnection: {}", conn);
    } catch (SQLException ex) {
      LOG.debug("[MYSQL] SQLException: " + ex.getMessage());
    }
    LOG.debug("[MYSQL] Initializing DAO of MariaDB log event [{}]", url);
  }

  @Override
  public JsonObject getJsonObject(String json) {
    LOG.debug("[MYSQL] Convert string to json", json);

    JsonParser  parser  = new JsonParser();
    JsonElement element = parser.parse(json);
    return (JsonObject)element.getAsJsonObject();
  }

  @Override
  public JsonArray getJsonSchema(String schema) {
    LOG.debug("[MYSQL] Extract schema from string", schema);
    
    JsonParser  parser  = new JsonParser();
    JsonElement element = parser.parse(schema);
    return (JsonArray)element.getAsJsonObject().get("fields");
  }

  @Override
  public String getSchemaField(String name, String type) {
    switch (type) {
      case "int"   : return name + " int";
      case "long"  : return name + " int";
      case "float" : return name + " float(12,2)";
      case "double": return name + " float(12,2)";
      case "string": return name + " varchar(64)";
      default      : return "";
    }
  }

  @Override
  public void createTable(String tableName, String schema) {
    LOG.debug("[MYSQL] create new MariaDB table ({}) for log appender", tableName);
    String data = "";
    String vals = "";
    try {
      JsonArray elements = getJsonSchema(schema);
      for (JsonElement element : elements) {
        String field = getSchemaField(element.getAsJsonObject().get("name").getAsString(), element.getAsJsonObject().get("type").getAsString());
        data += ((data == "") ? "" : ",") + field;
        vals += ((vals == "") ? "" : ",") + element.getAsJsonObject().get("name").getAsString();
      }
      fields = "ts, " + vals;

      ResultSet rs = conn.getMetaData().getTables(null, null, tableName, null);
      while (rs.next()) {
        String name = rs.getString("TABLE_NAME");
        if ((name != null) && (name.equals(tableName))) { 
          LOG.debug("[MYSQL] Database table ({}) already exist", tableName);
          return; 
        }
      }
      String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " ( id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, ts TIMESTAMP NOT NULL, " + data + " ) ";
      executeSql(sql);
      LOG.info("[MYSQL] SQL:CREATE {}", sql);
    } catch (SQLException ex) {
      LOG.debug("[MYSQL] SQLException: " + ex.getMessage());
    }
  }


  @Override
  public void executeSql(String qry) {
    LOG.debug("[MYSQL] execute SQL {} query", qry);
    try {
      PreparedStatement pstmt = conn.prepareStatement(qry);
      pstmt.executeUpdate();
      pstmt.close();
      conn.commit();
    } catch (SQLException ex) {
      LOG.debug("[MYSQL] SQLException: " + ex.getMessage());
    }
  }

  @Override
  public void save(List<LogEventDto> logEventDtos, String tableName) {
    long timestamp = new Timestamp(System.currentTimeMillis()).getTime();

    for (LogEventDto logEventDto : logEventDtos) {
      String data = "";
      JsonObject object = getJsonObject(logEventDto.getEvent());
      for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
        data += ((data == "") ? "" : ",") + entry.getValue();
      }
      String sql = "INSERT INTO " + tableName + " (" + fields + ") VALUES (CURRENT_TIMESTAMP, " + data + " ) ";
      executeSql(sql);
      LOG.info("[MYSQL] SQL:INSERT {}", sql);
    }
    LOG.debug("[MYSQL] Saving {} {} log events", timestamp, logEventDtos.size());
  }

  @Override
  public void removeAll(String tableName) {
    LOG.debug("[MYSQL] Remove all data from [{}] table.", tableName);
  }

  @Override
  public void close() {
    LOG.debug("[MYSQL] Close.");
  }
}
