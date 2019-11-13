package org.kaaproject.kaa.server.appenders.maria.appender;

import org.kaaproject.kaa.common.dto.logs.LogEventDto;
import org.kaaproject.kaa.server.common.log.shared.avro.gen.RecordHeader;

import java.util.List;

/**
 * 
 * @author Kim Jun Hyo, Araitech
 * @version 1.0.1
 * @since  2019-06-24 
 *
 */
public interface LogEventDao {

  void insert(RecordHeader header, List<LogEventDto> logEventDtos) throws Exception;

  void doExecuteSql(String sql) throws Exception;

  boolean tblExist(String tbl) throws Exception;

  void close();

}
