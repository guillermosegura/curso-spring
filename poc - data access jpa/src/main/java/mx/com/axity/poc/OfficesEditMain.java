package mx.com.axity.poc;

import mx.com.axity.poc.service.OfficeService;
import mx.com.axity.poc.to.Office;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OfficesEditMain
{
  private static final Logger LOG = LoggerFactory.getLogger( OfficesEditMain.class );

  public static void main( String[] args )
  {
    ApplicationContext context = new ClassPathXmlApplicationContext( "beans.xml" );

    OfficeService officeService = context.getBean( OfficeService.class );

    Office office = officeService.get( "8" );
    office.setCity( "Cd. de México" );

    officeService.edit( office );

    office = officeService.get( "8" );
    LOG.info("{}", office );
  }
}
