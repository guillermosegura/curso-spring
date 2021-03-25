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
    fail( "Not yet implemented" );
  }

  @Test
  public void testGet()
  {
    fail( "Not yet implemented" );
  }

  @Test
  public void testCreate()
  {
    fail( "Not yet implemented" );
  }

  @Test
  public void testEdit()
  {
    fail( "Not yet implemented" );
  }

  @Test
  public void testDelete()
  {
    fail( "Not yet implemented" );
  }

}
