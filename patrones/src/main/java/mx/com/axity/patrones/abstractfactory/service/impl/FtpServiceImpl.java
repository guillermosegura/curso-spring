package mx.com.axity.patrones.abstractfactory.service.impl;

import mx.com.axity.patrones.abstractfactory.message.Event;
import mx.com.axity.patrones.abstractfactory.message.Response;
import mx.com.axity.patrones.abstractfactory.service.CommunicationService;

public class FtpServiceImpl implements CommunicationService
{
  @Override
  public void init()
  {
    System.out.println( "Conexión a FTP" );

  }

  @Override
  public Response execute( Event event )
  {
    System.out.println( "Envío de archivos a FTP" );
    return null;
  }

}
