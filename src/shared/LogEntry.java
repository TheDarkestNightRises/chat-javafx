package client.model;

import java.io.Serializable;

public class LogEntry implements Serializable
{
  private String text;
  private String ip;
  private String date;
  private String time;

  public LogEntry(String ip, String date, String time, String text)
  {
    this.text = text;
    this.ip = ip;
    this.date= date;
    this.time = time;
  }

  public String getDate()
  {
    return date;
  }

  public String getIp()
  {
    return ip;
  }

  public String getText()
  {
    return text;
  }

  public String getTime()
  {
    return time;
  }
}
