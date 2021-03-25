package mx.com.axity.poc;

import mx.com.axity.poc.controller.ArithmeticController;
import mx.com.axity.poc.to.Operation;
import mx.com.axity.poc.to.OperationFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AspectMain
{
  private static final Logger LOG = LoggerFactory.getLogger( AspectMain.class );

  public static void main( String[] args )
  {

    ApplicationContext context = new AnnotationConfigApplicationContext( AppConfig.class );

    ArithmeticController arithmeticController = context.getBean( ArithmeticController.class );

    Operation op = OperationFactory.add( 1, 3 );
//    op = arithmeticController.execute( op );

    try
    {
      op = OperationFactory.divide( 1, 0 );
      op = arithmeticController.execute( op );
    }
    catch( RuntimeException e )
    {
      // doNothing
    }
    // op = OperationFactory.add( 2, 4 );
    // op = arithmeticController.execute( op );
    // op = OperationFactory.add( 4, 5 );
    // op = arithmeticController.execute( op );
    // op = OperationFactory.add( 6, 6 );
    // op = arithmeticController.execute( op );

    LOG.info( "{}", op );
  }

}
