package mx.com.axity.patrones.templatemethod.main;

import mx.com.axity.patrones.templatemethod.AbstractSocialNetwork;
import mx.com.axity.patrones.templatemethod.Facebook;
import mx.com.axity.patrones.templatemethod.Twitter;

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
