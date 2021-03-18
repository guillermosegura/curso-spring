package mx.com.axity.patrones.abstractfactory;

import mx.com.axity.patrones.abstractfactory.message.Type;
import mx.com.axity.patrones.abstractfactory.service.Service;
import mx.com.axity.patrones.abstractfactory.service.impl.LoggingEventServiceImpl;
import mx.com.axity.patrones.abstractfactory.service.impl.MonitorEventServiceImpl;
import mx.com.axity.patrones.abstractfactory.service.impl.SavingEventServiceImpl;

public class EventFactory implements AbstractFactory
{

  @Override
  public Service create( Type type )
  {
    Service service = null;

    if( type.equals( Type.LOGGING ) )
    {
      service = new LoggingEventServiceImpl();
    }
    else if( type.equals( Type.MONITOR ) )
    {
      service = new MonitorEventServiceImpl();
    }
    else if( type.equals( Type.SAVING ) )
    {
      service = new SavingEventServiceImpl();
    }
    return service;
  }

}
