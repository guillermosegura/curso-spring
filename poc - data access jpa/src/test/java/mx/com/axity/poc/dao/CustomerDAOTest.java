package mx.com.axity.poc.dao;

import static org.junit.Assert.fail;

import java.util.List;

import mx.com.axity.poc.entity.CustomerDO;
import mx.com.axity.poc.entity.EmployeeDO;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Pruebas unitarias de la interfaz {@link mx.com.axity.poc.dao.CustomerDAO}
 * 
 * @author guillermo.segura@axity.com
 */
@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:/beans.xml" })
@Transactional
public class CustomerDAOTest
{
  @Autowired
  private CustomerDAO customerDAO;

  @Autowired
  private EmployeeDAO employeeDAO;

  @Test
  public void testFindAll()
  {
    List<CustomerDO> customers = this.customerDAO.findAll();
    Assert.assertNotNull( customers );
    Assert.assertFalse( customers.isEmpty() );

  }

  @Test
  public void testFindByCustomerName()
  {
    List<CustomerDO> customers = this.customerDAO.findByCustomerName( "Volvo" );
    Assert.assertNotNull( customers );
    Assert.assertFalse( customers.isEmpty() );

    customers = this.customerDAO.findByCustomerName( "Mini" );
    Assert.assertNotNull( customers );
    Assert.assertFalse( customers.isEmpty() );

    customers = this.customerDAO.findByCustomerName( "Nelson" );
    Assert.assertNotNull( customers );
    Assert.assertTrue( customers.isEmpty() );
  }

  @Test
  public void testFindBySalesRepEmployee()
  {
    List<CustomerDO> customers = this.customerDAO.findBySalesRepEmployee( 1370L );
    Assert.assertNotNull( customers );
    Assert.assertFalse( customers.isEmpty() );

    customers = this.customerDAO.findBySalesRepEmployee( 1002L );
    Assert.assertNotNull( customers );
    Assert.assertTrue( customers.isEmpty() );
  }

  @Test
  public void testGet()
  {
    CustomerDO customer = this.customerDAO.get( 103L );
    Assert.assertNotNull( customer );

  }

  @Test(expected = RuntimeException.class)
  public void testGet_notFound()
  {
    CustomerDO customer = this.customerDAO.get( 99999L );
    Assert.assertNotNull( customer );

  }

  @Test()
  public void testCreate()
  {
    CustomerDO customerDO = new CustomerDO();
    customerDO.setCustomerName( "Test" );
    customerDO.setContactLastName( "Lopez" );
    customerDO.setContactFirstName( "Martha" );
    customerDO.setAddressLine1( "Calle 5 de Mayo 150" );
    customerDO.setCity( "CDMX" );
    customerDO.setCountry( "México" );
    customerDO.setPhone( "+52 5658 1111" );
    customerDO.setPostalCode( "11500" );

    this.customerDAO.create( customerDO );

    Assert.assertNotNull( this.customerDAO.get( customerDO.getCustomerNumber() ) );

  }

  @Test
  public void testEdit()
  {
    CustomerDO customer = this.customerDAO.get( 125L );

    EmployeeDO salesRepEmployee = this.employeeDAO.get( 1165L );

    customer.setSalesRepEmployee( salesRepEmployee );

    this.customerDAO.edit( customer );

    customer = this.customerDAO.get( 125L );
    Assert.assertNotNull( customer );
    Assert.assertNotNull( customer.getSalesRepEmployee() );
    Assert.assertEquals( 125L, customer.getSalesRepEmployee().getEmployeeNumber().longValue() );

  }

  @Test
  public void testDelete()
  {
    CustomerDO customerDO = new CustomerDO();
    customerDO.setCustomerName( "Test" );
    customerDO.setContactLastName( "Lopez" );
    customerDO.setContactFirstName( "Martha" );
    customerDO.setAddressLine1( "Calle 5 de Mayo 150" );
    customerDO.setCity( "CDMX" );
    customerDO.setCountry( "México" );
    customerDO.setPhone( "+52 5658 1111" );
    customerDO.setPostalCode( "11500" );

    this.customerDAO.create( customerDO );

    Long customerNumber = customerDO.getCustomerNumber();
    Assert.assertNotNull( customerNumber );

    this.customerDAO.delete( customerNumber );

    Assert.assertNull( this.customerDAO.get( customerNumber ) );
  }

}
