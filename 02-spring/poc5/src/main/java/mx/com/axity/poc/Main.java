package mx.com.axity.poc;

import mx.com.axity.poc.controller.Controller;
import mx.com.axity.poc.to.Data;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.SimpleLog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
  private static final Log LOG = new SimpleLog( "Main" );

  public static void main( String[] args )
  {

    ApplicationContext context = new AnnotationConfigApplicationContext( AppConfig.class );
    Controller controller = context.getBean( Controller.class );

    Data data = new Data();
    data.setName( "Guillermo" );
    data.setLastname( "Segura" );
    controller.save( data );

    Data myData = context.getBean( "myData", Data.class );
    LOG.info( myData );

    Data otraData = context.getBean( "otraData", Data.class );
    LOG.info( otraData );

//    data = null;

    try
    {
      controller.save( data );
    }
    catch( Exception e )
    {
      LOG.error( "Ocurrio un error con los datos: " + data );
      LOG.error( e.getMessage(), e );
    }
  }
}
