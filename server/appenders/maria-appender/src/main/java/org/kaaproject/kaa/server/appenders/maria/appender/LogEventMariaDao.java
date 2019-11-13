package org.kaaproject.kaa.server.appenders.maria.appender;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDriver;
import org.apache.commons.pool.impl.GenericObjectPool;

import org.kaaproject.kaa.common.dto.logs.LogEventDto;
import org.kaaproject.kaa.server.appenders.maria.appender.ConnectionManager;
import org.kaaproject.kaa.server.appenders.maria.config.gen.MariaDbConfig;
import org.kaaproject.kaa.server.common.log.shared.avro.gen.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Kim Jun Hyo, Araitech
 * @version 1.0.1
 * @since  2019-06-24 
 *
 */
public class LogEventMariaDao implements LogEventDao {

  private static final Logger LOG = LoggerFactory.getLogger(LogEventMariaDao.class);

  public LogEventMariaDao(MariaDbConfig configuration) throws Exception {
    //LOG.info("[MARIA] > LogEventMariaDao.init");
    ConnectionManager.init(configuration);
  }

  @Override
  public void insert(RecordHeader recordHeader, List<LogEventDto> logEventDtos) throws Exception {
    //LOG.info("[MARIA] = LogEventMariaDao.insert {}", logEventDtos);
    JsonParser parser = new JsonParser();
    JsonArray jsonArr = new JsonArray();
    
    for (int i = 0; i < logEventDtos.size(); i++) {
      jsonArr.add(parser.parse(logEventDtos.get(i).getEvent()));
      //LOG.debug("[MARIA] [{}] array[i]", jsonArr.get(i));
    }
    
    //LOG.debug("[MARIA] [{}] array", jsonArr);
    //LOG.debug("[MARIA] [{}] array size", jsonArr.size());
    
    for (int i = 0; i < jsonArr.size(); i++) {
      //LOG.debug("[MARIA] [{}] array size, [{}] insert", jsonArr.size(), i + 1);
      if (jsonArr.get(i).getAsJsonObject().get("DeviceId") != null) {
        //LOG.info("[MARIA] Sensor");
        sensor(jsonArr.get(i));
      } else {
        //LOG.info("[MARIA] Electr");
        elect(jsonArr.get(i));
      }
    }
  }
  
  @Override
  public void doExecuteSql(String sql) throws Exception {
    executeSql(sql);
  }

  @Override
  public boolean tblExist(String tbl) throws Exception {
    Connection conn = null;
    try {
      conn = ConnectionManager.getConnection();
      return checkTableExist(conn, tbl);
    } catch (Exception ex) {
      //return boolExist;
    }
    return false;
  }
 
  /**
   * tblExist.
   */
  public boolean checkTableExist(Connection conn, String tbl) throws Exception {
    boolean boolExist = false;
    try {
      ResultSet rs = conn.getMetaData().getTables(null, null, tbl, null);
      while (rs.next()) {
        String name = rs.getString("TABLE_NAME");
        if ((name != null) && (name.equals(tbl))) {
          boolExist = true;
          break;
        }
      }
    } catch (Exception ex) {
      //return boolExist;
    } 
    return boolExist;
  }

  /**
   * executeSql data.
   *
   */
  public void executeSql(String sql) throws Exception {
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
      conn = ConnectionManager.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.executeUpdate();
      pstmt.close();
      conn.commit();
    } catch (Exception ex) {
      //LOG.warn("[MARIA] Insert Failed", ex);
    } finally {
      if (pstmt != null) {
        pstmt.close();
      }
      if (conn != null) {
        conn.close();
      }
    }

  }


  /**
   * Sensor data.
   *
   */

  public void sensor(JsonElement element) throws Exception {
    Connection conn = null;
    PreparedStatement pstmt = null;

    int deviceId = element.getAsJsonObject().get("DeviceId").getAsInt();
    BigDecimal temperature = element.getAsJsonObject().get("Temperature").getAsBigDecimal();
    BigDecimal humidity = element.getAsJsonObject().get("Humidity").getAsBigDecimal();
    int fineDust = element.getAsJsonObject().get("FineDust").getAsInt();
    int ultrafineDust = element.getAsJsonObject().get("UltrafineDust").getAsInt();
    BigDecimal carbonMonoxide = element.getAsJsonObject().get("CarbonMonoxide").getAsBigDecimal();
    BigDecimal ozone = element.getAsJsonObject().get("Ozone").getAsBigDecimal();
    BigDecimal nitrogenDioxide = element.getAsJsonObject().get("NitrogenDioxide").getAsBigDecimal();

    long ldate = element.getAsJsonObject().get("DateTime").getAsLong();
    Date datea = new Date(ldate);
    SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.SSS");
    String sdate = df.format(datea);
    
    java.sql.Timestamp dateTime = java.sql.Timestamp.valueOf(sdate);

    try {
      String sql = "insert into T101_TBL values(?,?,?,?,?,?,?,?,?)";
      //LOG.info("[MARIA] {}", sql);
      conn = ConnectionManager.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, deviceId);
      pstmt.setBigDecimal(2, temperature);
      pstmt.setBigDecimal(3, humidity);
      pstmt.setInt(4, fineDust);
      pstmt.setInt(5, ultrafineDust);
      pstmt.setBigDecimal(6, carbonMonoxide);
      pstmt.setBigDecimal(7, ozone);
      pstmt.setBigDecimal(8, nitrogenDioxide);
      pstmt.setTimestamp(9, dateTime);

      pstmt.executeUpdate();
      conn.commit();
      //LOG.info("[MARIA] +++++++++++ insert end +++++++++++");

    } catch (Exception ex) {
      //LOG.warn("[MARIA] Insert Failed", ex);
    } finally {
      if (pstmt != null) {
        pstmt.close();
      }
      if (conn != null) {
        conn.close();
      }
    }
  }
  
  /**
   * electric data.
   *
   */

  public void elect(JsonElement element) throws Exception {
    Connection conn = null;
    PreparedStatement pstmt = null;

    int panelBoardId = element.getAsJsonObject().get("PanelBoardId").getAsInt();
    int electricPowerId = element.getAsJsonObject().get("ElectricPowerId").getAsInt();
    BigDecimal electricCurrentR = element.getAsJsonObject().get("ElectricCurrentR").getAsBigDecimal();
    BigDecimal electricCurrentS = element.getAsJsonObject().get("ElectricCurrentS").getAsBigDecimal();
    BigDecimal electricCurrentT = element.getAsJsonObject().get("ElectricCurrentT").getAsBigDecimal();
    BigDecimal powerFactor = element.getAsJsonObject().get("PowerFactor").getAsBigDecimal();
    BigDecimal activePower = element.getAsJsonObject().get("ActivePower").getAsBigDecimal();
    BigDecimal reactivePower = element.getAsJsonObject().get("ReactivePower").getAsBigDecimal();
    BigDecimal activePowerVolume = element.getAsJsonObject().get("ActivePowerVolume").getAsBigDecimal();
    BigDecimal reactivePowerVolume = element.getAsJsonObject().get("ReactivePowerVolume").getAsBigDecimal();
    BigDecimal phaseVoltageRs = element.getAsJsonObject().get("PhaseVoltageRS").getAsBigDecimal();
    BigDecimal phaseVoltageSt = element.getAsJsonObject().get("PhaseVoltageST").getAsBigDecimal();
    BigDecimal phaseVoltageTr = element.getAsJsonObject().get("PhaseVoltageTR").getAsBigDecimal();
    BigDecimal usePower = element.getAsJsonObject().get("UsePower").getAsBigDecimal();
    BigDecimal waitPower = element.getAsJsonObject().get("WaitPower").getAsBigDecimal();
    
    BigDecimal bd = new BigDecimal(103.4);
    BigDecimal useFee = usePower.multiply(bd);
    BigDecimal waitFee = waitPower.multiply(bd);
    int accumulateTime = element.getAsJsonObject().get("AccumulateTime").getAsInt();
    int operatingState = element.getAsJsonObject().get("OperatingState").getAsInt();

    long ldate = element.getAsJsonObject().get("DateTime").getAsLong();
    Date datea = new Date(ldate);
    SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.SSS");
    String sdate = df.format(datea);

    java.sql.Timestamp dateTime = java.sql.Timestamp.valueOf(sdate);

    try {
      String sql = "insert into T102_TBL values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      //LOG.info("[MARIA] {}", sql);
      conn = ConnectionManager.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, panelBoardId);
      pstmt.setInt(2, electricPowerId);
      pstmt.setBigDecimal(3, electricCurrentR);
      pstmt.setBigDecimal(4, electricCurrentS);
      pstmt.setBigDecimal(5, electricCurrentT);
      pstmt.setBigDecimal(6, powerFactor);
      pstmt.setBigDecimal(7, activePower);
      pstmt.setBigDecimal(8, reactivePower);
      pstmt.setBigDecimal(9, activePowerVolume);
      pstmt.setBigDecimal(10, reactivePowerVolume);
      pstmt.setBigDecimal(11, phaseVoltageRs);
      pstmt.setBigDecimal(12, phaseVoltageSt);
      pstmt.setBigDecimal(13, phaseVoltageTr);
      pstmt.setBigDecimal(14, usePower);
      pstmt.setBigDecimal(15, waitPower);
      pstmt.setBigDecimal(16, useFee);
      pstmt.setBigDecimal(17, waitFee);
      pstmt.setInt(18, accumulateTime);
      pstmt.setInt(19, operatingState);
      pstmt.setTimestamp(20, dateTime);

      pstmt.executeUpdate();
      conn.commit();
      //LOG.info("[MARIA] +++++++++++ insert end +++++++++++");

    } catch (Exception ex) {
      //LOG.warn("[MARIA] Insert Failed", ex);
    } finally {
      if (pstmt != null) {
        pstmt.close();
      }
      if (conn != null) {
        conn.close();
      }
    }
  }

  @Override
  public void close() {
  }
}
