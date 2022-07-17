package mx.com.axity.poc.service;

import static org.junit.Assert.fail;

import java.util.List;

import mx.com.axity.poc.to.Office;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:/beans.xml" })
@Transactional
public class OfficeServiceTest
{
  private static final Logger LOG = LoggerFactory.getLogger( OfficeServiceTest.class );

  @Autowired
  private OfficeService officeService;

  @Test
  public void testFindAll()
  {
    List<Office> offices = officeService.findAll();
    Assert.assertNotNull( offices );
    Assert.assertFalse( offices.isEmpty() );
    for( Office office : offices )
    {
      LOG.info( "{}", office );
    }
  }

  @Test
  public void testFindByTerritory()
  {
    List<Office> offices = officeService.findByTerritory( "NA" );

    Assert.assertNotNull( offices );
    Assert.assertFalse( offices.isEmpty() );

    for( Office office : offices )
    {
      LOG.info( "{}", office );
    }
  }

  /**
   * Esta prueba valida el escenario donde no hay registro
   */
  @Test
  public void testFindByTerritory_empty()
  {
    List<Office> offices = officeService.findByTerritory( "ACME" );

    Assert.assertNotNull( offices );
    Assert.assertTrue( offices.isEmpty() );

  }

  @Test
  public void testGet()
  {
    Office office = officeService.get( "1" );
    Assert.assertNotNull( office );

  }

  @Test
  public void testCreate()
  {
    Assert.assertNull( this.officeService.get( "10" ) );
    Office office = new Office();
    office.setOfficeCode( "10" );
    office.setCity( "CDMX" );
    office.setPhone( "+52 55 50 46 92 00" );
    office.setAddressLine1( "Av Ejército Nacional 350," );
    office.setAddressLine2( "piso 5 Polanco V Sección" );
    office.setState( "CDMX" );
    office.setCountry( "México" );
    office.setPostalCode( "11560" );
    office.setTerritory( "LATAM" );

    officeService.create( office );
    Assert.assertNotNull( this.officeService.get( "10" ) );
    
  }

  @Test
  public void testEdit()
  {
    Office office = this.officeService.get( "1" );
    String myCity = "My City";
    office.setCity( myCity  );
    
    this.officeService.edit( office );
    
    Assert.assertEquals( myCity, this.officeService.get( "1" ).getCity() );
    
  }

  @Test
  public void testDelete()
  {
    Office office = new Office();
    office.setOfficeCode( "11" );
    office.setCity( "CDMX" );
    office.setPhone( "+52 55 50 46 92 00" );
    office.setAddressLine1( "Av Ejército Nacional 350," );
    office.setAddressLine2( "piso 5 Polanco V Sección" );
    office.setState( "CDMX" );
    office.setCountry( "México" );
    office.setPostalCode( "11560" );
    office.setTerritory( "LATAM" );

    officeService.create( office );
    Assert.assertNotNull( this.officeService.get( "11" ) ); 
    
    officeService.delete( "11" );
    
    Assert.assertNull( this.officeService.get( "11" ) ); 
    
  }

}
