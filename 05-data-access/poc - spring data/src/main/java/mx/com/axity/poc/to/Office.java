package mx.com.axity.poc.to;

import java.io.Serializable;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Objeto de transferencia de Oficina
 * 
 * @author guillermo.segura@axity.com
 */
public class Office implements Serializable
{

  private static final long serialVersionUID = -1468484645398717478L;
  private String officeCode;
  private String city;
  private String phone;
  private String addressLine1;
  private String addressLine2;
  private String state;
  private String country;
  private String postalCode;
  private String territory;
  private List<Employee> employees;

  /**
   * @return the officeCode
   */
  public String getOfficeCode()
  {
    return officeCode;
  }

  /**
   * @param officeCode the officeCode to set
   */
  public void setOfficeCode( String officeCode )
  {
    this.officeCode = officeCode;
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
   * @return the territory
   */
  public String getTerritory()
  {
    return territory;
  }

  /**
   * @param territory the territory to set
   */
  public void setTerritory( String territory )
  {
    this.territory = territory;
  }

  /**
   * @return the employees
   */
  public List<Employee> getEmployees()
  {
    return employees;
  }

  /**
   * @param employees the employees to set
   */
  public void setEmployees( List<Employee> employees )
  {
    this.employees = employees;
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
