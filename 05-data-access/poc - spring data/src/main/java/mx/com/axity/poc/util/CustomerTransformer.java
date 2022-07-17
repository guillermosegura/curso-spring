package mx.com.axity.poc.util;

import mx.com.axity.poc.entity.CustomerDO;
import mx.com.axity.poc.to.Customer;

/**
 * @author guillermo.segura@axity.com
 */
public final class CustomerTransformer
{
  private CustomerTransformer()
  {
  }

  /**
   * Convierte una entidad {@link mx.com.axity.poc.entity.CustomerDO} en un {@link mx.com.axity.poc.to.Customer}
   * 
   * @param e
   * @return
   */
  public static Customer transform( CustomerDO e )
  {
    Customer customer = null;
    if( e != null )
    {
      customer = new Customer();
      customer.setAddressLine1( e.getAddressLine1() );
      customer.setAddressLine2( e.getAddressLine2() );
      customer.setCity( e.getCity() );
      customer.setContactFirstName( e.getContactLastName() );
      customer.setContactLastName( e.getContactLastName() );
      customer.setCountry( e.getCountry() );
      customer.setCreditLimit( e.getCreditLimit() );
      customer.setCustomerName( e.getCustomerName() );
      customer.setCustomerNumber( e.getCustomerNumber() );
      customer.setPhone( e.getPhone() );
      customer.setPostalCode( e.getPostalCode() );
      customer.setSalesRepEmployee( EmployeeTransformer.transform( e.getSalesRepEmployee() ) );
      customer.setState( e.getState() );
    }
    return customer;
  }
}
