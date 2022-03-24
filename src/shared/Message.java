package shared;

import client.model.User;

import java.time.LocalDate;
import java.time.LocalTime;

public class Message
{
  private String message;
  private LocalDate date;
  private LocalTime time;
  private User user;

  private Message(User user, String message)
  {
    this.user = user;
    this.message = message;
    this.date = getCurrentDate();
    this.time = getCurrentTime();
  }

  private LocalTime getCurrentTime()
  {
    return LocalTime.now();
  }

  private LocalDate getCurrentDate()
  {
    return LocalDate.now();
  }

  public LocalDate getDate()
  {
    return date;
  }

  public LocalTime getTime()
  {
    return time;
  }

  public String getMessage()
  {
    return message;
  }

  public User getUser()
  {
    return user;
  }
}
