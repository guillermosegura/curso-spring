package mx.com.axity.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.com.axity.poc.controller.ArithmeticController;
import mx.com.axity.poc.service.SimpleService;
import mx.com.axity.poc.to.Operation;
import mx.com.axity.poc.to.OperationFactory;
import mx.com.axity.poc.to.Strange;

public class BeforeAspectMain
{
  private static final Logger LOG = LoggerFactory.getLogger( BeforeAspectMain.class );

  public static void main( String[] args )
  {

    ApplicationContext context = new ClassPathXmlApplicationContext( "beans-before-aspect.xml" );

    ArithmeticController arithmeticController = context.getBean( ArithmeticController.class );

    Operation op = OperationFactory.add( 1, 3 );
    op = arithmeticController.execute( op );
    LOG.info( "---> {}", op );

    op = OperationFactory.add( 2, 4 );
    op = arithmeticController.execute( op );
    LOG.info( "---> {}", op );

    op = OperationFactory.add( 4, 5 );
    op = arithmeticController.execute( op );
    LOG.info( "---> {}", op );

    op = OperationFactory.add( 6, 6 );
    op = arithmeticController.execute( op );
    LOG.info( "---> {}", op );

     SimpleService simpleService = context.getBean( SimpleService.class );
     simpleService.doSomething();
     simpleService.doSomethingElse();
     simpleService.hello( "World!" );
    
     simpleService.somethingStrange( new Strange( 123 ) );
    
     LOG.info( "{}", op );
  }

}
