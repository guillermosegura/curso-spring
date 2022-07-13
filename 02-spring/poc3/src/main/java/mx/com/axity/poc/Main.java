package mx.com.axity.poc;

import mx.com.axity.poc.controller.Controller;
import mx.com.axity.poc.to.Data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{

  public static void main( String[] args )
  {

    // Inicia inyección de dependencias
    ApplicationContext context = new ClassPathXmlApplicationContext( "beans.xml" );
    // Termina inyeccion de dependencias

    // Service locator
    Controller controller = (Controller) context.getBean( "controller" );
    System.out.println( "-----------" );
    Data data = new Data();
    data.setName( "Guillermo" );
    data.setLastname( "Segura" );
    controller.save( data );

  }

}
