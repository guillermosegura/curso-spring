package mx.com.axity.poc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import mx.com.axity.poc.entity.OfficeDO;
import mx.com.axity.poc.persistence.OfficeRepository;
import mx.com.axity.poc.service.OfficeService;
import mx.com.axity.poc.to.Office;

/**
 * Implementación de la interface {@link mx.com.axity.poc.service.OfficeService}
 * 
 * @author guillermo.segura@axity.com
 */
public class OfficeServiceImpl implements OfficeService
{
  @Autowired
  private OfficeRepository officeRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Office> findAll()
  {
    List<Office> list = null;

    List<OfficeDO> offices = officeRepository.findAll();
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

    List<OfficeDO> offices = officeRepository.findByTerritory( territory );
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
    var op = officeRepository.findById( officeCode );
    if( op.isPresent() )
    {
      return transform( op.get() );
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void create( Office office )
  {
    officeRepository.save( transform( office ) );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void edit( Office office )
  {
    officeRepository.save( transform( office ) );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete( String officeCode )
  {
    officeRepository.deleteById( officeCode );
  }

  private Office transform( OfficeDO entity )
  {
    Office to = null;
    if( entity != null )
    {
      to = new Office();
      BeanUtils.copyProperties( entity, to );
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
