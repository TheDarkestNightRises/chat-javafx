package chat.client.model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable
{

  private String username;
  private String password;

  public User(String username, String password)
  {
    this.username = username;
    this.password = password;
  }


  public String getUsername()
  {
    return username;
  }

  public String getPassword()
  {
    return password;
  }

  @Override public String toString()
  {
    return "User{" + "username='" + username + '\'' + ", password='" + password
        + '\'' + '}';
  }

  @Override public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    User user = (User) o;
    return Objects.equals(username, user.username) && Objects.equals(password,
        user.password);
  }

  @Override public int hashCode()
  {
    return Objects.hash(username, password);
  }
}
