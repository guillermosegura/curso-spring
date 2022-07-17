package mx.com.axity.poc.to;

import java.math.BigDecimal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author guillermo.segura@axity.com
 */
public class Customer
{
  private Long customerNumber;

  private String customerName;

  private String contactLastName;

  private String contactFirstName;

  private String phone;

  private String addressLine1;

  private String addressLine2;

  private String city;

  private String state;

  private String postalCode;

  private String country;

  private Employee salesRepEmployee;

  private BigDecimal creditLimit;

  /**
   * @return the customerNumber
   */
  public Long getCustomerNumber()
  {
    return customerNumber;
  }

  /**
   * @param customerNumber the customerNumber to set
   */
  public void setCustomerNumber( Long customerNumber )
  {
    this.customerNumber = customerNumber;
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
   * @return the addressLine1
   */
  public String getAddressLine1()
  {
    return addressLine1;
  }

  /**
   * @param addressLine1 the addressLine1 to set
   */
  public void setAddressLine1( String addressLine1 )
  {
    this.addressLine1 = addressLine1;
  }

  /**
   * @return the addressLine2
   */
  public String getAddressLine2()
  {
    return addressLine2;
  }

  /**
   * @param addressLine2 the addressLine2 to set
   */
  public void setAddressLine2( String addressLine2 )
  {
    this.addressLine2 = addressLine2;
  }

  /**
   * @return the city
   */
  public String getCity()
  {
    return city;
  }

  /**
   * @param city the city to set
   */
  public void setCity( String city )
  {
    this.city = city;
  }

  /**
   * @return the state
   */
  public String getState()
  {
    return state;
  }

  /**
   * @param state the state to set
   */
  public void setState( String state )
  {
    this.state = state;
  }

  /**
   * @return the postalCode
   */
  public String getPostalCode()
  {
    return postalCode;
  }

  /**
   * @param postalCode the postalCode to set
   */
  public void setPostalCode( String postalCode )
  {
    this.postalCode = postalCode;
  }

  /**
   * @return the country
   */
  public String getCountry()
  {
    return country;
  }

  /**
   * @param country the country to set
   */
  public void setCountry( String country )
  {
    this.country = country;
  }

  /**
   * @return the salesRepEmployee
   */
  public Employee getSalesRepEmployee()
  {
    return salesRepEmployee;
  }

  /**
   * @param salesRepEmployee the salesRepEmployee to set
   */
  public void setSalesRepEmployee( Employee salesRepEmployee )
  {
    this.salesRepEmployee = salesRepEmployee;
  }

  /**
   * @return the creditLimit
   */
  public BigDecimal getCreditLimit()
  {
    return creditLimit;
  }

  /**
   * @param creditLimit the creditLimit to set
   */
  public void setCreditLimit( BigDecimal creditLimit )
  {
    this.creditLimit = creditLimit;
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
