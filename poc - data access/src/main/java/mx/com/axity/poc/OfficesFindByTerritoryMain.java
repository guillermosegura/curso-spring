package mx.com.axity.poc;

import java.util.List;

import mx.com.axity.poc.service.OfficeService;
import mx.com.axity.poc.to.Office;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OfficesFindByTerritoryMain
{
  private static final Logger LOG = LoggerFactory.getLogger( OfficesFindByTerritoryMain.class );

  public static void main( String[] args )
  {
    ApplicationContext context = new ClassPathXmlApplicationContext( "beans.xml" );

    OfficeService officeService = context.getBean( OfficeService.class );
    List<Office> offices = officeService.findByTerritory( "LATAM" );

    for( Office office : offices )
    {
      LOG.info( "{}", office );
    }
  }
}
