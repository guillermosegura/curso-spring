package mx.com.axity.poc;

import mx.com.axity.poc.controller.Controller;
import mx.com.axity.poc.to.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
  private static final Logger LOG = LoggerFactory.getLogger( Main.class );

  public static void main( String[] args )
  {

    ApplicationContext context = new AnnotationConfigApplicationContext( AppConfig.class );
    Controller controller = context.getBean( Controller.class );

    Data data = new Data();
    data.setName( "Guillermo" );
    data.setLastname( "Segura" );
    controller.save( data );

    int a = 1;
    String cadena = "cadena";
//    String msg = "Valor " + 1 + "-" + "cadena";
    LOG.info( "Este es un mensaje {} {} {}", a, cadena, data );
  }

}
