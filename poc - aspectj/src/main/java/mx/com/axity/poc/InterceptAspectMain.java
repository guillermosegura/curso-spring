package mx.com.axity.poc;

import mx.com.axity.poc.service.SimpleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InterceptAspectMain
{
  private static final Logger LOG = LoggerFactory.getLogger( InterceptAspectMain.class );

  public static void main( String[] args )
  {

    ApplicationContext context = new AnnotationConfigApplicationContext( AppConfig.class );

    SimpleService simpleService = context.getBean( "simpleService", SimpleService.class );
    simpleService.doSomething();
    simpleService.doSomethingElse();
    
    SimpleService anotherSimpleService = context.getBean( "anotherSimpleService", SimpleService.class );
    anotherSimpleService.doSomething();
    anotherSimpleService.doSomethingElse();

  }

}
