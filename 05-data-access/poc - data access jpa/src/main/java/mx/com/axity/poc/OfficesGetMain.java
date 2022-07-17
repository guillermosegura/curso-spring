package mx.com.axity.poc;

import mx.com.axity.poc.service.OfficeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OfficesGetMain
{
  private static final Logger LOG = LoggerFactory.getLogger( OfficesGetMain.class );

  public static void main( String[] args )
  {
    ApplicationContext context = new ClassPathXmlApplicationContext( "beans-h2embedded.xml" );

    OfficeService officeService = context.getBean( OfficeService.class );

    LOG.info( "{}", officeService.get( "1" ) );
    LOG.info( "{}", officeService.get( "5" ) );
    LOG.info( "{}", officeService.get( "9" ) );
  }
}
