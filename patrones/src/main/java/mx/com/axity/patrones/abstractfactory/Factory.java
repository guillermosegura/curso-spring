package mx.com.axity.patrones.abstractfactory;

import mx.com.axity.patrones.abstractfactory.message.ServiceType;

public class Factory
{

  public static AbstractFactory getFactory( ServiceType serviceType )
  {
    AbstractFactory factory = null;
    if( serviceType.equals( ServiceType.COMMUNICATION ) )
    {
      factory = new CommunicationFactory();
    }
    else if( serviceType.equals( ServiceType.EVENT ) )
    {
      factory = new EventFactory();
    }
    return factory;
  }
}
