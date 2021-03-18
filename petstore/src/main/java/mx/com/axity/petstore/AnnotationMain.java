package mx.com.axity.petstore;

import mx.com.axity.petstore.service.AService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationMain
{

  public static void main( String[] args )
  {
    ApplicationContext context = new ClassPathXmlApplicationContext( "annotation.xml" );

    AService aService = context.getBean( AService.class );
    aService.doSomething();
  }
}
