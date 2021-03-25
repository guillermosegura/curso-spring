package mx.com.axity.poc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entidad de la tabla payments
 * 
 * @author guillermo.segura@axity.com
 */
@Entity
@Table(name = "payments")
public class PaymentDO
{

  @EmbeddedId
  private PaymentId id;

  @ManyToOne(fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", insertable = false, updatable = false)
  private CustomerDO customer;

  @Column(name = "paymentDate", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date paymentDate;

  @Column(name = "amount", precision = 10, scale = 2)
  private double amount;

  /**
   * @return the id
   */
  public PaymentId getId()
  {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId( PaymentId id )
  {
    this.id = id;
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
   * @return the customer
   */
  public CustomerDO getCustomer()
  {
    return customer;
  }

  /**
   * @param customer the customer to set
   */
  public void setCustomer( CustomerDO customer )
  {
    this.customer = customer;
  }

  /**
   * @return the amount
   */
  public double getAmount()
  {
    return amount;
  }

  /**
   * @param amount the amount to set
   */
  public void setAmount( double amount )
  {
    this.amount = amount;
  }

}
