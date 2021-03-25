package mx.com.axity.poc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.com.axity.poc.dao.CustomerDAO;
import mx.com.axity.poc.entity.CustomerDO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase que implementa la interface {@link mx.com.axity.poc.dao.impl.CustomerDAOImpl}
 * 
 * @author TBD
 */
public class CustomerDAOImpl implements CustomerDAO
{

  private static final Logger LOG = LoggerFactory.getLogger( CustomerDAOImpl.class );

  @PersistenceContext
  private EntityManager em;

  @Override
  public List<CustomerDO> findAll()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<CustomerDO> findByCustomerName( String customerName )
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<CustomerDO> findBySalesRepEmployee( Long employeeNumber )
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public CustomerDO get( Long customerNumber )
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void create( CustomerDO customer )
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void edit( CustomerDO customer )
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete( Long customerNumber )
  {
    // TODO Auto-generated method stub

  }

}
