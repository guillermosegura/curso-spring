package mx.com.axity.poc.service;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import mx.com.axity.poc.dao.DataDAO;
import mx.com.axity.poc.service.impl.ServiceImpl;
import mx.com.axity.poc.to.Data;

import static org.mockito.Mockito.*;

/**
 * @author guillermo.segura@axity.com
 *
 */
public class ServiceTest
{
  private Service service;

  @Before
  public void setUp() {
    service = new ServiceImpl();
    
    // Mocking
    var dataDAO = mock(DataDAO.class);
    ReflectionTestUtils.setField( service, "dataDAO", dataDAO );
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
