package mx.com.axity.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.com.axity.poc.service.OfficeService;
import mx.com.axity.poc.to.Office;

public class OfficesCreateMain
{
  private static final Logger LOG = LoggerFactory.getLogger( OfficesCreateMain.class );

  public static void main( String[] args )
  {
    LOG.trace( "init" );
    ApplicationContext context = new ClassPathXmlApplicationContext( "beans-h2embedded.xml" );

    OfficeService officeService = context.getBean( OfficeService.class );

    Office office = new Office();
    office.setOfficeCode( "9" );
    office.setCity( "CDMX" );
    office.setPhone( "+52 55 50 46 92 00" );
    office.setAddressLine1( "Av Ejército Nacional 350," );
    office.setAddressLine2( "piso 5 Polanco V Sección" );
    office.setState( "CDMX" );
    office.setCountry( "México" );
    office.setPostalCode( "11560" );
    office.setTerritory( "LATAM" );

    LOG.trace( "-> create" );
    officeService.create( office );
    LOG.trace( "<- create" );
    
    var created = officeService.get( "9" );
    LOG.debug( "Office: {}", created );
    
    LOG.trace( "-> delete" );
    officeService.delete( "9");
    LOG.trace( "-> delete" );
    
    created = officeService.get( "9" );
    LOG.debug( "Office: {}", created );
  }
}
