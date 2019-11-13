package org.kaaproject.kaa.server.appenders.maria.appender;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.kaaproject.kaa.common.dto.logs.LogAppenderDto;
import org.kaaproject.kaa.common.dto.logs.LogEventDto;
import org.kaaproject.kaa.server.appenders.maria.config.gen.MariaDbConfig;
import org.kaaproject.kaa.server.common.log.shared.appender.AbstractLogAppender;
import org.kaaproject.kaa.server.common.log.shared.appender.LogDeliveryCallback;
import org.kaaproject.kaa.server.common.log.shared.appender.LogEventPack;
import org.kaaproject.kaa.server.common.log.shared.avro.gen.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Kim Jun Hyo, Araitech
 * @version 1.0.1
 * @since  2019-06-24 
 *
 */

public class MariaDbLogAppender extends AbstractLogAppender<MariaDbConfig> {

  private static final Logger LOG = LoggerFactory.getLogger(MariaDbLogAppender.class);
    
  private LogEventDao logEventDao = null;
  private boolean closed = false;

  public MariaDbLogAppender() {
    super(MariaDbConfig.class);
  }
    
  /**
   * Inits the appender from configuration.
   *
   * @param appender the metadata object that contains useful info like application token, tenant id, etc.
   * @param configuration the configuration object that you have specified during appender provisioning.
   */
  
  @Override
  protected void initFromConfiguration(LogAppenderDto appender, MariaDbConfig configuration) {
    try {
      LOG.info("[MARIA] initFromConfiguration {} [{}]", getName(), configuration);
      this.logEventDao = new LogEventMariaDao(configuration);
    } catch (Exception ex) {
      LOG.info("[MARIA] Fail to initFromConfiguration: ", ex);
    }
  }

  // hyhwang
  /**
   * getJsonObject.
   */
  public JsonObject getJsonObject(String json, String name) throws Exception {
    JsonParser  parser  = new JsonParser();
    JsonElement element = parser.parse(json);
    return (JsonObject)element.getAsJsonObject().get(name);
  }

  /**
   * getType.
   */
  public String getType(String name, String type) throws Exception {
    switch (type) {
      case "int"   : return name + " int";
      case "long"  : return name + " int";
      case "float" : return name + " float(12,2)";
      case "double": return name + " float(12,2)";
      case "string": return name + " varchar(64)";
      default      : return "";
    }
  }

  /**
   * doBuildTbl.
   */
  public void doBuildTbl(String tbl, String schema) throws Exception {
    JsonParser  parser  = new JsonParser();
    JsonElement element = parser.parse(schema);
    String fields = "";

    LOG.info("[MARIA] doBuildTbl {} {} {}", tbl, schema, element);
    JsonArray array = (JsonArray)element.getAsJsonObject().get("fields");
    for (int i = 0; i < array.size(); i++) {
      String name = array.get(i).getAsJsonObject().get("name").getAsString();
      String type = array.get(i).getAsJsonObject().get("type").getAsString();
      if (i > 0) {
        fields += ", ";
      }

      fields += getType(name, type);
    }
    String sql = "CREATE TABLE IF NOT EXISTS " + tbl + " ( " + fields + " ) ";
    LOG.info("[MARIA] SQL {}", sql);
    this.logEventDao.doExecuteSql(sql);
  }

  /**
   * getInsertSQL.
   */
  public void getSql(String tbl, String event) throws Exception {
    JsonParser  parser  = new JsonParser();
    JsonObject  object  = parser.parse(event).getAsJsonObject();

    Set<String> keys = object.keySet();
    LOG.info("[MARIA] getSql {}", keys);
    LOG.info("[MARIA] getSql {}", object.get("temperature"));
    LOG.info("[MARIA] getSql {}", object);
  }

  @Override
  public void doAppend(LogEventPack logEventPack, RecordHeader header, LogDeliveryCallback listener) {
    try {
      if (!closed) {
        try {
          LOG.debug("[MARIA] token {}, schema [{}], getEvents [{}] ", getApplicationToken(), logEventPack.getLogSchema().getSchema(), logEventPack.getEvents());
          LOG.debug("[MARIA] header.getClassSchema {}", header.getClassSchema());
          LOG.debug("[MARIA] logEventPack.getEvents {}", logEventPack.getEvents().get(0).getLogData());

          LOG.info("[MARIA] tblExist === {}", this.logEventDao.tblExist(getName()));

          if (this.logEventDao.tblExist(getName()) == false) {
            doBuildTbl(getName(), logEventPack.getLogSchema().getSchema());
          }

          // hyhwang (11.12)
          List<LogEventDto> listdtos = generateLogEvent(logEventPack, header);
          for (int i = 0 ; i < listdtos.size(); i++) {
            String event  = listdtos.get(i).getEvent();

            LOG.info("[MARIA] listdtos.get 1 {}", getJsonObject(listdtos.get(i).getHeader(), "timestamp"));
            LOG.info("[MARIA] listdtos.get 2 {}", getJsonObject(listdtos.get(i).getHeader(), "timestamp").get("long"));

            long timestamp = getJsonObject(listdtos.get(i).getHeader(), "timestamp").get("long").getAsLong();
            LOG.info("[MARIA] listdtos.get 2 {}", (timestamp / 1000));

            LOG.info("[MARIA] listdtos.get 3 {}", getJsonObject(listdtos.get(i).getHeader(), "timestamp").get("long").getClass().getName());
            LOG.info("[MARIA] listdtos.get 4 {}", listdtos.get(i).getEvent());
            LOG.info("[MARIA] listdtos.get 5 {}", listdtos.get(i).getEvent().getClass().getName());

            getSql(getName(), listdtos.get(i).getEvent());
          }
          listener.onSuccess();
        } catch (Exception ex) {
          LOG.info("[MARIA] Failed to log event: ", ex);
          listener.onInternalError();
        }
      } else {
        LOG.info("[MARIA] internal error {}", getName());
        listener.onInternalError();
      } 
    } catch (Exception ex) {
      LOG.info("[MARIA] Failed to init maria log appender: ", ex);
    }
  }
    
  /**
   * Closes this appender and releases any resources associated with it.
   *
   */
  
  @Override
  public void close() {
    if (!closed) {
      closed = true;
      if (logEventDao != null) {
        logEventDao.close();
        logEventDao = null;
      }
    }
  }
}
