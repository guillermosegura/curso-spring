package mx.com.axity.patrones.templatemethod;

public class Main
{

  public static void main( String[] args )
  {
    String username = "username";
    String password = "password";
    AbstractSocialNetwork sn = new Facebook( username, password );
    sn.post( "qwerty" );

    System.out.println( "================================================" );
    sn = new Twitter( username, password );
    sn.post( "qwerty" );
  }

}
