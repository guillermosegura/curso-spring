package mx.com.axity.poc.to;

import java.math.BigDecimal;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author guillermo.segura@axity.com
 */
public class CustomerPayment
{
  private String customerName;

  private String contactLastName;

  private String contactFirstName;

  private String phone;

  private Date paymentDate;

  private BigDecimal amount;

  public CustomerPayment()
  {
  }

  public CustomerPayment( String customerName, 
      String contactLastName, 
      String contactFirstName, 
      String phone, 
      Date paymentDate, 
      BigDecimal amount )
  {
    this.customerName = customerName;
    this.contactLastName = contactLastName;
    this.contactFirstName = contactFirstName;
    this.phone = phone;
    this.paymentDate = paymentDate;
    this.amount = amount;
  }

  /**
   * @return the customerName
   */
  public String getCustomerName()
  {
    return customerName;
  }

  /**
   * @param customerName the customerName to set
   */
  public void setCustomerName( String customerName )
  {
    this.customerName = customerName;
  }

  /**
   * @return the contactLastName
   */
  public String getContactLastName()
  {
    return contactLastName;
  }

  /**
   * @param contactLastName the contactLastName to set
   */
  public void setContactLastName( String contactLastName )
  {
    this.contactLastName = contactLastName;
  }

  /**
   * @return the contactFirstName
   */
  public String getContactFirstName()
  {
    return contactFirstName;
  }

  /**
   * @param contactFirstName the contactFirstName to set
   */
  public void setContactFirstName( String contactFirstName )
  {
    this.contactFirstName = contactFirstName;
  }

  /**
   * @return the phone
   */
  public String getPhone()
  {
    return phone;
  }

  /**
   * @param phone the phone to set
   */
  public void setPhone( String phone )
  {
    this.phone = phone;
  }

  /**
   * @return the paymentDate
   */
  public Date getPaymentDate()
  {
    return paymentDate;
  }

  /**
   * @param paymentDate the paymentDate to set
   */
  public void setPaymentDate( Date paymentDate )
  {
    this.paymentDate = paymentDate;
  }

  /**
   * @return the amount
   */
  public BigDecimal getAmount()
  {
    return amount;
  }

  /**
   * @param amount the amount to set
   */
  public void setAmount( BigDecimal amount )
  {
    this.amount = amount;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString()
  {
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    return gson.toJson( this );
  }
}
