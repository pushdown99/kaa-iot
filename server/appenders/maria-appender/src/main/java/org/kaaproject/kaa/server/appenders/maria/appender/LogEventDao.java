package org.kaaproject.kaa.server.appenders.maria.appender;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.kaaproject.kaa.common.dto.logs.LogEventDto;
import org.kaaproject.kaa.server.common.log.shared.avro.gen.RecordHeader;

import java.util.List;

public interface LogEventDao {

  JsonObject getJsonObject(String json);

  JsonArray getJsonSchema(String schema);

  String getSchemaField(String name, String type);

  void createTable(String tableName, String schema);

  void executeSql(String qry);

  void save(List<LogEventDto> logEventDtos, String collectionName);

  void removeAll(String tableName);

  void close();

}
