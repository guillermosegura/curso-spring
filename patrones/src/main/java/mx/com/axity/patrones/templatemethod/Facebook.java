package mx.com.axity.patrones.templatemethod;

public class Facebook extends AbstractSocialNetwork
{

  public Facebook( String username, String password )
  {
    this.username = username;
    this.password = password;
  }

  @Override
  protected boolean login( String userName, String password )
  {
    System.out.println( "Login Facebook" );
    return true;
  }

  @Override
  protected boolean sendData( String message )
  {
    System.out.println( "Mensaje a enviar: " + message );
    return true;
  }

  @Override
  protected void logout()
  {
    System.out.println( "User: '" + this.username + "' was logged out from Facebook" );
  }

}
