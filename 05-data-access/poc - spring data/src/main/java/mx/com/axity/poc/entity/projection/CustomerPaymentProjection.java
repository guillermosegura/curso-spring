package mx.com.axity.poc.entity.projection;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author guillermo.segura@axity.com
 */
public interface CustomerPaymentProjection
{
  String getCustomerName();
  
  String getContactLastName();
  
  String getContactFirstName();
  
  String getPhone();
  
  Date getPaymentDate();
  
  BigDecimal getAmount();
}
