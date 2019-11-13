package org.kaaproject.kaa.server.appenders.maria.appender;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDriver;
import org.apache.commons.pool.impl.GenericObjectPool;

import org.kaaproject.kaa.server.appenders.maria.config.gen.MariaDbConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Kim Jun Hyo, Araitech
 * @version 1.0.1
 * @since  2019-06-24 
 *
 */

public class ConnectionManager {
  private static final Logger LOG = LoggerFactory.getLogger(ConnectionManager.class);
  private static String poolName = null;
  private static String driverClassName = null;
  private static String url = null;
  private static String userName = null;
  private static String password = null;
  private static int maxActive;
  private static int maxIdle;
  private static int minIdle;
  private static long timeBetweenEvictionRunsMillis;
  private static int numTestsPerEvictionRun;
  private static long minEvictableIdleTimeMillis;  
  private static byte whenExhaustedAction;
  private static long maxWait;
  private static boolean testOnBorrow = false;
  private static boolean testOnReturn = false;
  private static boolean testWhileIdle;
  private static String vQuery = null;
  private static boolean autoCommit = false;
  private static boolean readOnly = false;
  
  
  /**
   * ConnectionManager init.
   *
   */
  
  public static void init(MariaDbConfig configuration) {
    String servers = "";
    for (int i = 0; i < configuration.getMariaServers().size(); i++) {
      servers += configuration.getMariaServers().get(i).get("host") + ":" + configuration.getMariaServers().get(i).get("port");
      if (i + 1 != configuration.getMariaServers().size()) {
        servers += ",";
      }
    }
    
    poolName        = "pool";
    driverClassName = "org.mariadb.jdbc.Driver";
    userName        = configuration.getUser();
    password        = configuration.getPassword();
    maxActive       = configuration.getMaxactive();
    maxIdle         = configuration.getMaxidle();
    minIdle         = configuration.getMinidle();
    
    url = "jdbc:mariadb://" + servers + "/" + configuration.getDbname();
    LOG.info("[MARIA] url = {}, maxActive = {}, maxIdle = {}, minIdle = {}", url, maxActive, maxIdle, minIdle);
    
    timeBetweenEvictionRunsMillis = 1800000L;
    numTestsPerEvictionRun        = 1;
    minEvictableIdleTimeMillis    = 3600000L;
    whenExhaustedAction           = 1;
    maxWait                       = 10000L;
    testOnBorrow                  = false;
    testOnReturn                  = false;
    testWhileIdle                 = true;
    vQuery                        = "select 1";
    autoCommit                    = false;
    readOnly                      = false;

    try {
      Class.forName(driverClassName);
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    }
    GenericObjectPool connectionPool = new GenericObjectPool(null);
    connectionPool.setMaxActive(maxActive);
    connectionPool.setMaxIdle(maxIdle);
    connectionPool.setMinIdle(minIdle);
    connectionPool.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
    connectionPool.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
    connectionPool.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
    connectionPool.setWhenExhaustedAction(whenExhaustedAction);
    connectionPool.setMaxWait(maxWait);
    connectionPool.setTestOnBorrow(testOnBorrow);
    connectionPool.setTestOnReturn(testOnReturn);
    connectionPool.setTestWhileIdle(testWhileIdle);
    
    ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(url, userName, password);
    PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, connectionPool, null, vQuery, readOnly, autoCommit);
    try {
      Class.forName("org.apache.commons.dbcp.PoolingDriver");
      PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
      driver.registerPool(poolName, poolableConnectionFactory.getPool());
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
  
  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection("jdbc:apache:commons:dbcp:" + poolName);
  }
}
