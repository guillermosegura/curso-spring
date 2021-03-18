package mx.com.axity.patrones.templatemethod;

public abstract class AbstractSocialNetwork
{
  protected String username;
  protected String password;

  public boolean post( String message )
  {
    boolean result = false;
    if( login( this.username, this.password ) )
    {
      result = sendData( message );
      logout();
    }
    return result;
  }

  protected abstract boolean login( String userName, String password );

  protected abstract boolean sendData( String message );

  protected abstract void logout();
}
