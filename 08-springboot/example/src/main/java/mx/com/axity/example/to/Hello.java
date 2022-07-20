package mx.com.axity.example.to;

import java.io.Serializable;

/**
 * @author guillermo.segura@axity.com
 */
public class Hello implements Serializable
{

  private static final long serialVersionUID = -5213324245442108107L;
  private String message;

  public Hello()
  {
  }

  public Hello( String message )
  {
    this.message = message;
  }

  /**
   * @return the message
   */
  public String getMessage()
  {
    return message;
  }

  /**
   * @param message the message to set
   */
  public void setMessage( String message )
  {
    this.message = message;
  }

}
