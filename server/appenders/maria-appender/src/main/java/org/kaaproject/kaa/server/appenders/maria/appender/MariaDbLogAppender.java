package org.kaaproject.kaa.server.appenders.maria.appender;

import org.kaaproject.kaa.common.dto.logs.LogAppenderDto;
import org.kaaproject.kaa.common.dto.logs.LogEventDto;
import org.kaaproject.kaa.server.appenders.maria.config.gen.MariaDbConfig;
import org.kaaproject.kaa.server.common.log.shared.appender.AbstractLogAppender;
import org.kaaproject.kaa.server.common.log.shared.appender.LogDeliveryCallback;
import org.kaaproject.kaa.server.common.log.shared.appender.LogEventPack;
import org.kaaproject.kaa.server.common.log.shared.appender.data.ProfileInfo;
import org.kaaproject.kaa.server.common.log.shared.avro.gen.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.List;

public class MariaDbLogAppender extends AbstractLogAppender<MariaDbConfig> {

  private static final Logger LOG = LoggerFactory.getLogger(MariaDbLogAppender.class);

  private LogEventDao logEventDao;
  private String  tableName = "";
  private boolean closed = false;

  public MariaDbLogAppender() {
    super(MariaDbConfig.class);
  }

  @Override
  public void doAppend(LogEventPack logEventPack, RecordHeader header, LogDeliveryCallback listener) {
    if (!closed) {
      if (tableName == "") {
        tableName = "log_" + getName();
        tableName = tableName.replaceAll("\\s+","").toLowerCase();
        logEventDao.createTable(tableName, logEventPack.getLogSchema().getSchema());
      }
      try {
        LOG.debug("[MYSQL] 'table: {}' appending {} logs to mariadb table", tableName, logEventPack.getEvents().size());
        List<LogEventDto> dtos = generateLogEvent(logEventPack, header);
        LOG.debug("[MYSQL] 'table: {}' saving {} objects", tableName, dtos.size());
        if (!dtos.isEmpty()) {
          logEventDao.save(dtos, tableName);
          LOG.debug("[MYSQL] 'table: {}' appended {} logs to mariadb table", tableName, logEventPack.getEvents().size());
        }
        listener.onSuccess();
      } catch (Exception ex) {
        LOG.error(MessageFormat.format("[MYSQL] [{0}] Attempted to append logs failed " + "due to internal error", getName()), ex);
        listener.onInternalError();
      }
    } else {
      LOG.info("[MYSQL] Attempted to append to closed appender named [{}].", tableName);
      listener.onInternalError();
    }
  }

  @Override
  protected void initFromConfiguration(LogAppenderDto appender, MariaDbConfig configuration) {    
    LOG.debug("[MYSQL] Initializing new instance of MariaDB log appender: {}", getName());
    try {
      logEventDao = new LogEventMariaDao(configuration); 
    } catch (Exception ex) {
      LOG.error("[MYSQL] Failed to init MariaDB log appender: ", ex);
    }
  }

  @Override
  public void close() {
    if (!closed) {
      closed = true;
      if (logEventDao != null) {
        logEventDao.close();
        logEventDao = null;
      }
    }
    LOG.debug("[MYSQL] Stopped MariaDB log appender.");
  }
}
