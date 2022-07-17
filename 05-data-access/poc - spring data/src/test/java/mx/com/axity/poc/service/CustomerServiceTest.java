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

/**
 * @author guillermo.segura@axity.com
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:/beans.xml" })
@Transactional
public class CustomerServiceTest
{
  private static final Logger LOG = LoggerFactory.getLogger( CustomerServiceTest.class );

  @Autowired
  private CustomerService customerService;

  @Test
  public void testFindAll()
  {
    var customers = this.customerService.findAll();
    Assert.assertNotNull( customers );
    customers.stream().forEach( o -> LOG.info( "{}", o ) );
  }

  @Test
  public void testFindByState()
  {
    var customers = this.customerService.findByState( "CA" );
    Assert.assertNotNull( customers );
    customers.stream().forEach( o -> LOG.info( "{}", o ) );
  }

  @Test
  public void testFindByStateAndPostalCode()
  {
    var customers = this.customerService.findByStateAndPostalCode( "CA", "91217" );
    Assert.assertNotNull( customers );
    customers.stream().forEach( o -> LOG.info( "{}", o ) );
  }

  @Test
  public void testFindCustomerPayments()
  {
    var payments = this.customerService.findCustomerPayments( 114L );
    Assert.assertNotNull( payments );
    payments.stream().forEach( o -> LOG.info( "{}", o ) );
  }
}
