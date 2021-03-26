package mx.com.axity.poc;

import java.util.List;

import mx.com.axity.poc.service.OfficeService;
import mx.com.axity.poc.to.Office;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OfficesDeleteMain
{
  private static final Logger LOG = LoggerFactory.getLogger( OfficesDeleteMain.class );

  public static void main( String[] args )
  {
    ApplicationContext context = new ClassPathXmlApplicationContext( "beans.xml" );

    OfficeService officeService = context.getBean( OfficeService.class );

    officeService.delete( "8" );

    LOG.info( "{}", officeService.get( "9" ) );
  }
}
