package mx.com.axity.patrones.abstractfactory.service.impl;

import mx.com.axity.patrones.abstractfactory.message.Event;
import mx.com.axity.patrones.abstractfactory.message.Response;
import mx.com.axity.patrones.abstractfactory.service.EventService;

public class SavingEventServiceImpl implements EventService
{
  @Override
  public void init()
  {
  }

  @Override
  public Response execute( Event event )
  {
    System.out.println( "Guardado de registros" );
    return null;
  }

}
