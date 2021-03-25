package mx.com.axity.poc;

import mx.com.axity.poc.controller.ArithmeticController;
import mx.com.axity.poc.to.Operation;
import mx.com.axity.poc.to.OperationFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AroundAspectMain
{
  private static final Logger LOG = LoggerFactory.getLogger( AroundAspectMain.class );

  public static void main( String[] args )
  {

    ApplicationContext context = new ClassPathXmlApplicationContext( "beans-around-aspect.xml" );

    ArithmeticController arithmeticController = context.getBean( ArithmeticController.class );

    Operation op = OperationFactory.divide( 1, 0 );
    // op.setB( null );
    op = arithmeticController.execute( op );
    // op = OperationFactory.add( 2, 4 );
    // op = arithmeticController.execute( op );
    // op = OperationFactory.add( 4, 5 );
    // op = arithmeticController.execute( op );
    // op = OperationFactory.add( 6, 6 );
    // op = arithmeticController.execute( op );

    LOG.info( "{}", op );
  }

}
