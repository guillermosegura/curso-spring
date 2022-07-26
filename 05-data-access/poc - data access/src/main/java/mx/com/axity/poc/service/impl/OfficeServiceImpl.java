package mx.com.axity.poc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.com.axity.poc.aop.Intercept;
import mx.com.axity.poc.dao.OfficeDAO;
import mx.com.axity.poc.service.OfficeService;
import mx.com.axity.poc.to.Office;

/**
 * Implementación de la interface {@link mx.com.axity.poc.service.OfficeService}
 * 
 * @author guillermo.segura@axity.com
 */
@Intercept
@Transactional
public class OfficeServiceImpl implements OfficeService
{
  @Autowired
  private OfficeDAO officeDAO;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Office> findAll()
  {
    return officeDAO.findAll();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Office> findByTerritory( String territory )
  {
    return officeDAO.findByTerritory( territory );
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public List<Office> findByTerritoryLambda( String territory ){
    return officeDAO.findByTerritoryLambda( territory );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Office get( String officeCode )
  {
    return officeDAO.get( officeCode );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void create( Office office )
  {
    officeDAO.create( office );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void edit( Office office )
  {
    officeDAO.edit( office );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete( String officeCode )
  {
    officeDAO.delete( officeCode );
  }

}
