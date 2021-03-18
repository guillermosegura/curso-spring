package mx.com.axity.petstore;

import mx.com.axity.petstore.config.AppConfig;
import mx.com.axity.petstore.to.Foo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConfigMain
{

  public static void main( String[] args )
  {
    ApplicationContext ctx = new AnnotationConfigApplicationContext( AppConfig.class );

    Foo foo = ctx.getBean( Foo.class );
    foo.setBar( "bar 123" );
    foo.doSomething();

  }

}
