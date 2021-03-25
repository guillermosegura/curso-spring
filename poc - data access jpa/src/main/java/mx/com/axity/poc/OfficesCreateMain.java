package mx.com.axity.poc;

import mx.com.axity.poc.service.OfficeService;
import mx.com.axity.poc.to.Office;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OfficesCreateMain
{
  private static final Logger LOG = LoggerFactory.getLogger( OfficesCreateMain.class );

  public static void main( String[] args )
  {
    ApplicationContext context = new ClassPathXmlApplicationContext( "beans.xml" );

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

    officeService.create( office );
    
    
  }
}
