package mx.com.axity.poc;

import java.security.Provider.Service;

import mx.com.axity.poc.controller.Controller;
import mx.com.axity.poc.to.Data;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataBeansMain
{

  public static void main( String[] args )
  {

    ApplicationContext context = new ClassPathXmlApplicationContext( "beans-with-data.xml" );

    Data data = null;

    data = context.getBean( "user1", Data.class );
    System.out.println( "user1:" + data );

    data = context.getBean( "user2", Data.class );
    System.out.println( "user2:" + data );

    data = context.getBean( "user3", Data.class );
    System.out.println( "user3:" + data );

    data = context.getBean( "user4", Data.class );
    System.out.println( "user4:" + data );

    data = context.getBean( "empty", Data.class );
    System.out.println( "empty:" + data );

    // Controller controller = context.getBean( Controller.class );
    // controller.save( context.getBean( "user2", Data.class ) );

  }

}
