package mx.com.axity.patrones.abstractfactory;

import mx.com.axity.patrones.abstractfactory.message.Event;
import mx.com.axity.patrones.abstractfactory.message.ServiceType;

public class Client
{

  public void sendMessage( Event event )
  {
    Factory.getFactory( ServiceType.COMMUNICATION ).create( event.getType() ).execute( event );
  }

  public void sendEvent( Event event )
  {
    Factory.getFactory( ServiceType.EVENT ).create( event.getType() ).execute( event );
  }
}
