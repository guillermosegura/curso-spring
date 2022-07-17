package mx.com.axity.poc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import mx.com.axity.poc.AppConfigTest;
import mx.com.axity.poc.to.Data;

/**
 * @author guillermo.segura@axity.com
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { AppConfigTest.class })
public class ServiceSpringTest
{
  @Autowired
  private Service service;

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
