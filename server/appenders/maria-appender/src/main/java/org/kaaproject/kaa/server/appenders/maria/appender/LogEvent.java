package org.kaaproject.kaa.server.appenders.maria.appender;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 
 * @author Kim Jun Hyo, Araitech
 * @version 1.0.1
 * @since  2019-06-24 
 *
 */
public final class LogEvent implements Serializable {

  private static final long serialVersionUID = -1L;
  private String header = "";
  private String event = "";

  public LogEvent() {

  }

  public String getHeader() {
    return header;
  }


  public void setHeader(String header) {
    this.header = header;
  }


  public String getEvent() {
    return event;
  }


  public void setEvent(String event) {
    this.event = event;
  }


  @Override
  public String toString() {
    return "LogEvent [header=" + header + ", event=" + event + "]";
  }
}