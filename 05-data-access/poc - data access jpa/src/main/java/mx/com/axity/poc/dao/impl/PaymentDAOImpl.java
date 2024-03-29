package mx.com.axity.poc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import mx.com.axity.poc.aop.Intercept;
import mx.com.axity.poc.dao.PaymentDAO;
import mx.com.axity.poc.entity.PaymentDO;

/**
 * Implementacion de la interface {@link mx.com.axity.poc.dao.impl.PaymentDAOImpl}
 * 
 * @author guillermo.segura@axity.com
 */
@Intercept
@Repository
public class PaymentDAOImpl implements PaymentDAO
{

  private static final Logger LOG = LoggerFactory.getLogger( PaymentDAOImpl.class );

  @PersistenceContext
  private EntityManager em;

  @Override
  public List<PaymentDO> findAllByCustomerNumber( Long customerNumber )
  {
    TypedQuery<PaymentDO> query = em.createQuery( "SELECT p FROM PaymentDO p"
        + " WHERE p.id.customerNumber = :customerNumber" //
        + " ORDER BY p.paymentDate, p.id.checkNumber ", PaymentDO.class );
    query.setParameter( "customerNumber", customerNumber );
    return query.getResultList();
  }

  @Override
  public PaymentDO get( Long customerNumber, String checkNumber )
  {
    TypedQuery<PaymentDO> query = em.createQuery( "SELECT p FROM PaymentDO p"
        + " WHERE p.id.customerNumber = :customerNumber" //
        + " AND p.id.checkNumber = :checkNumber ", PaymentDO.class );
    query.setParameter( "customerNumber", customerNumber );
    query.setParameter( "checkNumber", checkNumber );
    PaymentDO payment;
    try
    {
      payment = query.getSingleResult();
    }
    catch( NoResultException e )
    {
      LOG.warn( "No se encontraron pagos asociados" );
      payment = null;
    }
    return payment;
  }

  @Override
  public void create( PaymentDO payment )
  {
    em.persist( payment );
  }

  @Override
  public void edit( PaymentDO payment )
  {
    PaymentDO entity = this.get( payment.getId().getCustomerNumber(), payment.getId().getCheckNumber() );
    if( entity != null )
    {
      entity.setAmount( payment.getAmount() );
      entity.setPaymentDate( payment.getPaymentDate() );
      em.merge( entity );
    }
    else
    {
      LOG.warn( "No se encontraron pagos asociados" );
      throw new RuntimeException( "No se encontraron pagos asociados" );
    }

  }

  @Override
  public void delete( Long customerNumber, String checkNumber )
  {
    PaymentDO entity = this.get( customerNumber, checkNumber );
    if( entity != null )
    {
      em.remove( entity );
    }
    else
    {
      LOG.warn( "No se encontraron pagos asociados" );
      throw new RuntimeException( "No se encontraron pagos asociados" );
    }
  }

}
