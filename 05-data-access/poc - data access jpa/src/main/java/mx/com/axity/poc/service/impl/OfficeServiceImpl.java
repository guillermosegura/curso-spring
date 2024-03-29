package mx.com.axity.poc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import mx.com.axity.poc.aop.Intercept;
import mx.com.axity.poc.dao.OfficeDAO;
import mx.com.axity.poc.entity.EmployeeDO;
import mx.com.axity.poc.entity.OfficeDO;
import mx.com.axity.poc.service.OfficeService;
import mx.com.axity.poc.to.Employee;
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
    List<Office> list = null;

    List<OfficeDO> offices = officeDAO.findAll();
    if( offices != null )
    {
      list = new ArrayList<Office>( offices.size() );
      for( OfficeDO office : offices )
      {
        list.add( transform( office ) );
      }
    }

    return list;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Office> findByTerritory( String territory )
  {
    List<Office> list = null;

    List<OfficeDO> offices = officeDAO.findByTerritory( territory );
    if( offices != null )
    {
      list = new ArrayList<Office>( offices.size() );
      for( OfficeDO office : offices )
      {
        list.add( transform( office ) );
      }
    }
    return list;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Office get( String officeCode )
  {
    return transform( officeDAO.get( officeCode ) );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void create( Office office )
  {
    officeDAO.create( transform( office ) );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void edit( Office office )
  {
    officeDAO.edit( transform( office ) );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete( String officeCode )
  {
    officeDAO.delete( officeCode );
  }

  private Office transform( OfficeDO entity )
  {
    Office to = null;
    if( entity != null )
    {
      to = new Office();
      BeanUtils.copyProperties( entity, to );

      if( entity.getEmployees() != null && !entity.getEmployees().isEmpty() )
      {
        to.setEmployees( new ArrayList<>() );
        for( EmployeeDO employeeDO : entity.getEmployees() )
        {
          Employee employee = new Employee();
          employee.setEmployeeNumber( employeeDO.getEmployeeNumber() );
          employee.setLastName( employeeDO.getLastName() );
          employee.setFirstName( employeeDO.getFirstName() );
          to.getEmployees().add( employee );
        }
      }
    }
    return to;
  }

  private OfficeDO transform( Office to )
  {
    OfficeDO entity = null;
    if( to != null )
    {
      entity = new OfficeDO();
      BeanUtils.copyProperties( to, entity );
    }
    return entity;
  }
}
