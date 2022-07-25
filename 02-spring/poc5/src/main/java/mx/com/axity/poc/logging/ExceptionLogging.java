package mx.com.axity.poc.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author guillermo.segura@axity.com
 */
public class ExceptionLogging
{
  private static final Log LOG = LogFactory.getLog( "Logging" );

  public static void main( String[] args )
  {
    try
    {
      int n = 1 / 0;
    }
    catch( RuntimeException e )
    {
//      e.printStackTrace();
      LOG.error( e.getMessage(), e );
    }
  }
}
