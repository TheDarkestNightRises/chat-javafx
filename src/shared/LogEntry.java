package shared;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class LogEntry implements Serializable
{
  private String text;
  private String ip;
  private LocalDate date;
  private LocalTime time;

  public LogEntry(String text, String ip, LocalDate date, LocalTime time)
  {
    this.text = text;
    this.ip = ip;
    this.date = date;
    this.time = time;
  }

  public String getText()
  {
    return text;
  }

  public String getIp()
  {
    return ip;
  }

  public LocalDate getDate()
  {
    return date;
  }

  public LocalTime getTime()
  {
    return time;
  }
}
