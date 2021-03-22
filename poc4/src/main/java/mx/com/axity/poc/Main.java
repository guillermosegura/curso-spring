package mx.com.axity.poc;

import mx.com.axity.poc.controller.Controller;
import mx.com.axity.poc.to.Data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{

  public static void main( String[] args )
  {

    ApplicationContext context = new ClassPathXmlApplicationContext( "beans.xml" );
    Controller controller = context.getBean( Controller.class );

    Data data = new Data();
    data.setName( "Guillermo" );
    data.setLastname( "Segura" );
    controller.save( data );

  }

}
