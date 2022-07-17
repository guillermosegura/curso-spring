package mx.com.axity.poc.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import mx.com.axity.poc.to.Office;


/**
 * @author guillermo.segura@axity.com
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:/beans.xml" })
@Transactional
public class OfficeServiceTest
{
  private static final Logger LOG = LoggerFactory.getLogger( OfficeServiceTest.class );
  
  @Autowired
  private OfficeService officeService;
  
  /**
   * Test method for {@link mx.com.axity.poc.service.impl.OfficeServiceImpl#findAll()}.
   */
  @Test
  public void testFindAll()
  {
    var offices = this.officeService.findAll();
    Assert.assertNotNull( offices );
    offices.stream().forEach( o -> LOG.info( "{}", o ) );
  }

  /**
   * Test method for {@link mx.com.axity.poc.service.impl.OfficeServiceImpl#findByTerritory(java.lang.String)}.
   */
  @Test
  public void testFindByTerritory()
  {
    var offices = this.officeService.findByTerritory( "NA" );
    Assert.assertNotNull( offices );
    offices.stream().forEach( o -> LOG.info( "{}", o ) );
  }

  /**
   * Test method for {@link mx.com.axity.poc.service.impl.OfficeServiceImpl#get(java.lang.String)}.
   */
  @Test
  public void testGet()
  {
    var office = this.officeService.get( "1" );
    Assert.assertNotNull( office );
    LOG.info( "{}", office );
  }

  /**
   * Test method for {@link mx.com.axity.poc.service.impl.OfficeServiceImpl#create(mx.com.axity.poc.to.Office)}.
   */
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

  /**
   * Test method for {@link mx.com.axity.poc.service.impl.OfficeServiceImpl#edit(mx.com.axity.poc.to.Office)}.
   */
  @Test
  public void testEdit()
  {
    Office office = this.officeService.get( "1" );
    String myCity = "My City";
    office.setCity( myCity  );
    
    this.officeService.edit( office );
    
    Assert.assertEquals( myCity, this.officeService.get( "1" ).getCity() );
  }

  /**
   * Test method for {@link mx.com.axity.poc.service.impl.OfficeServiceImpl#delete(java.lang.String)}.
   */
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
