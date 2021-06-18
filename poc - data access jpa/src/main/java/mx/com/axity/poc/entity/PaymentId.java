package mx.com.axity.poc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Llave compuesta de la tabla payments
 * 
 * @author guillermo.segura@axity.com
 */
@Embeddable
public class PaymentId implements Serializable
{

  private static final long serialVersionUID = 8207197912982355628L;

  @Column(name = "customerNumber", nullable = false)
  private Long customerNumber;

  @Column(name = "checkNumber", nullable = false)
  private String checkNumber;

  @Override
  public boolean equals( Object object )
  {
    boolean isEquals = false;
    if (this == object){
      isEquals = true;
    } else if (object != null && object.getClass().equals( this.getClass() )){
      PaymentId that = (PaymentId) object;
      
      isEquals = this.customerNumber.equals( that.checkNumber );
     // Objects.is      
    }
    return isEquals;
  }

  /**
   * Constructor default
   */
  public PaymentId()
  {
  }

  /**
   * Constructor por argumentos
   * 
   * @param customerNumber
   * @param checkNumber
   */
  public PaymentId( Long customerNumber, String checkNumber )
  {
    this.customerNumber = customerNumber;
    this.checkNumber = checkNumber;
  }

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
   * @return the checkNumber
   */
  public String getCheckNumber()
  {
    return checkNumber;
  }

  /**
   * @param checkNumber the checkNumber to set
   */
  public void setCheckNumber( String checkNumber )
  {
    this.checkNumber = checkNumber;
  }

}
