package mx.com.axity.patrones.abstractfactory.service.impl;

import mx.com.axity.patrones.abstractfactory.message.Event;
import mx.com.axity.patrones.abstractfactory.message.Response;
import mx.com.axity.patrones.abstractfactory.service.EventService;

public class LoggingEventServiceImpl implements EventService
{
  @Override
  public void init()
  {
    // doNothing
  }

  @Override
  public Response execute( Event event )
  {
    System.out.println( "Registra bitácora" );
    return null;
  }

}
