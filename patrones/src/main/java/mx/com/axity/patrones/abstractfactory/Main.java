package mx.com.axity.patrones.abstractfactory;

import mx.com.axity.patrones.abstractfactory.message.Event;
import mx.com.axity.patrones.abstractfactory.message.Message;
import mx.com.axity.patrones.abstractfactory.message.Type;

public class Main
{

  public static void main( String[] args )
  {
    Client client = new Client();

    Event event = new Event();
    event.setType( Type.EMAIL );
    event.setMessage( new Message() );

    client.sendMessage( event );
    System.out.println( "===============================" );

    event = new Event();
    event.setType( Type.SMS );
    event.setMessage( new Message() );

    client.sendMessage( event );

    System.out.println( "===============================" );
    event = new Event();
    event.setType( Type.FTP );
    event.setMessage( new Message() );

    client.sendMessage( event );

    System.out.println( "===============================" );
    event = new Event();
    event.setType( Type.LOGGING );
    event.setMessage( new Message() );

    client.sendEvent( event );
    System.out.println( "===============================" );
    event = new Event();
    event.setType( Type.MONITOR );
    event.setMessage( new Message() );

    client.sendEvent( event );
    System.out.println( "===============================" );
    event = new Event();
    event.setType( Type.SAVING );
    event.setMessage( new Message() );

    client.sendEvent( event );
  }

}
