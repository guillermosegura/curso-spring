package mx.com.axity.poc.service;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.spel.support.ReflectionHelper;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ReflectionUtils;

import mx.com.axity.poc.dao.DataDAO;
import mx.com.axity.poc.service.impl.ServiceImpl;
import mx.com.axity.poc.to.Data;

/**
 * @author guillermo.segura@axity.com
 */
public class ServiceTest
{

  private Service service;

  @Before
  public void setup()
  {
    service = new ServiceImpl();
    
    // Stubbing
    ReflectionTestUtils.setField( service, "dataDAO", new DataDAO()
    {

      @Override
      public void insert( Data data )
      {
        System.out.println( String.format( "Dummy DataDAO insert: {%s %s}", data.getName(), data.getLastname() ) );
      }

    } );
  }

  /**
   * Test method for {@link mx.com.axity.poc.service.impl.ServiceImpl#save(mx.com.axity.poc.to.Data)}.
   */
  @Test
  public void testSave()
  {
    var data = new Data();
    data.setName( "Homer" );
    data.setLastname( "Simpson" );
    service.save( data );
  }

}
