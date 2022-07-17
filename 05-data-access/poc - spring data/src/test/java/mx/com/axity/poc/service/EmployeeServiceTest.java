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
public class EmployeeServiceTest
{
  private static final Logger LOG = LoggerFactory.getLogger( EmployeeServiceTest.class );
  
  @Autowired
  private EmployeeService employeeService;
  
  @Test
  public void testFindAll() {
    var employees = this.employeeService.findAll();
    Assert.assertNotNull( employees );
    employees.stream().forEach( o -> LOG.info( "{}", o ) );
  }
  
  @Test
  public void testFindByLastName() {
    var lastName = "Patterson";
    var employees = this.employeeService.findByLastName(lastName);
    Assert.assertNotNull( employees );
    employees.stream().forEach( o -> LOG.info( "{}", o ) );
  }
  
  @Test
  public void testFindByEmail() {
    var email = "mpatterso@classicmodelcars.com";
    var employee = this.employeeService.findByEmail(email);
    Assert.assertNotNull( employee );
    LOG.info( "{}", employee );
  }
  
  @Test
  public void testFindByEmail_notExists() {
    var email = "nobody@classicmodelcars.com";
    var employee = this.employeeService.findByEmail(email);
    Assert.assertNull( employee );
  }
  
  @Test
  public void testFindByTerritory() {
    var territory = "NA";
    var employees = this.employeeService.findByTerritory(territory);
    Assert.assertNotNull( employees );
    employees.stream().forEach( o -> LOG.info( "{}", o ) );
  }
}
