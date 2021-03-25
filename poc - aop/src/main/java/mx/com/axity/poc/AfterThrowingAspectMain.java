package mx.com.axity.poc;

import mx.com.axity.poc.controller.ArithmeticController;
import mx.com.axity.poc.to.Operation;
import mx.com.axity.poc.to.OperationFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AfterThrowingAspectMain
{
  private static final Logger LOG = LoggerFactory.getLogger( AfterThrowingAspectMain.class );

  public static void main( String[] args )
  {

    ApplicationContext context = new ClassPathXmlApplicationContext( "beans-after-throwing-aspect.xml" );

    ArithmeticController arithmeticController = context.getBean( ArithmeticController.class );

    try
    {
      Operation op = OperationFactory.divide( 1, 0 );
      op = arithmeticController.execute( op );

      LOG.info( "{}", op );
    }
    catch( RuntimeException e )
    {
      LOG.error( "Ocurrió un error inesperado" );
    }
  }

}
