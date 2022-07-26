package mx.com.axity.poc;

import mx.com.axity.poc.service.OfficeService;
import mx.com.axity.poc.to.Office;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class OfficesEditMain
{
  private static final Logger LOG = LoggerFactory.getLogger( OfficesEditMain.class );

  public static void main( String[] args )
  {
    ApplicationContext context = new ClassPathXmlApplicationContext( "beans-h2embedded.xml" );

    OfficeService officeService = context.getBean( OfficeService.class );
    
    Office office = new Office();
    office.setOfficeCode( "8" );
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

    office = officeService.get( "8" );
    office.setCity( "Cd. de México" );
    office.setOfficeCode( "9999" );

    officeService.edit( office );

    office = officeService.get( "8" );
    LOG.info("{}", office );
    
    officeService.delete( "8" );
    LOG.info("{}", office );
  }
}
