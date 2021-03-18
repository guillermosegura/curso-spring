package mx.com.axity.patrones.abstractfactory.service.impl;

import mx.com.axity.patrones.abstractfactory.message.Event;
import mx.com.axity.patrones.abstractfactory.message.Response;
import mx.com.axity.patrones.abstractfactory.service.EventService;

public class MonitorEventServiceImpl implements EventService
{
  @Override
  public void init()
  {
    System.out.println( "Conexión a sistema de monitoreo" );

  }

  @Override
  public Response execute( Event event )
  {
    System.out.println( "Activa monitoreo..." );
    return null;
  }

}
