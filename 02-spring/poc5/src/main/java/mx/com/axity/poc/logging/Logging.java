package mx.com.axity.poc.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author guillermo.segura@axity.com
 */
public class Logging
{
  private static final Log LOG = LogFactory.getLog( "Logging" );

  public static void main( String[] args )
  {
    LOG.fatal( "Ocurrió un error irrecuperable, la aplicación no puede continuar" );
    LOG.error( "Ocurrió un error de negocio y/o comunicaciones" );
    LOG.warn( "Mensaje de advertencia" );
    LOG.info( "Mensaje informativo, provee data necesaria para análisis posterior" );
    LOG.debug( "Mensaje a nivel debug, datos para diagnosticar" );
    LOG.trace( "Menor nivel de bitacoreo (Paso 1...n)" );
  }
}
