package mx.com.axity.poc.util;

import mx.com.axity.poc.entity.projection.CustomerPaymentProjection;
import mx.com.axity.poc.to.CustomerPayment;

/**
 * @author guillermo.segura@axity.com
 */
public final class CustomerPaymentTransformer
{
  private CustomerPaymentTransformer()
  {
  }

  public static CustomerPayment transform( CustomerPaymentProjection e )
  {
    CustomerPayment customerPayment = null;
    if( e != null )
    {
      customerPayment = new CustomerPayment();
      customerPayment.setAmount( e.getAmount() );
      customerPayment.setContactFirstName( e.getContactFirstName() );
      customerPayment.setContactLastName( e.getContactLastName() );
      customerPayment.setCustomerName( e.getCustomerName() );
      customerPayment.setPaymentDate( e.getPaymentDate() );
      customerPayment.setPhone( e.getPhone() );
    }

    return customerPayment;
  }
}
