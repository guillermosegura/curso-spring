package mx.com.axity.patrones.abstractfactory.service.impl;

import mx.com.axity.patrones.abstractfactory.message.Event;
import mx.com.axity.patrones.abstractfactory.message.Response;
import mx.com.axity.patrones.abstractfactory.service.CommunicationService;

public class EmailServiceImpl implements CommunicationService
{
  @Override
  public void init()
  {
    System.out.println( "Inicializa el servicio de correos" );

  }

  @Override
  public Response execute( Event event )
  {
    System.out.println( "Envia email" );
    return null;
  }

}
