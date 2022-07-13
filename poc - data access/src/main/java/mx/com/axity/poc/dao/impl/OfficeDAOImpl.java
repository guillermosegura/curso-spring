package mx.com.axity.poc.dao.impl;

import java.util.List;

import mx.com.axity.poc.dao.OfficeDAO;
import mx.com.axity.poc.dao.mapper.OfficeMapper;
import mx.com.axity.poc.to.Office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Implementación del dao {@link mx.com.axity.poc.dao.OfficeDAO}
 * 
 * @author guillermo.segura@axity.com
 */
public class OfficeDAOImpl implements OfficeDAO
{

  private static final String QUERY_FIND_ALL = "SELECT officeCode, city, phone, addressLine1,"
      + " addressLine2, state, country, postalCode, territory " //
      + " FROM offices ORDER BY officeCode";

  private static final String QUERY_FIND_BY_TERRITORY = 
      "SELECT officeCode, city, phone, addressLine1,"
      + " addressLine2, state, country, postalCode, territory " //
      + " FROM offices"//
      + " WHERE territory = ?" //
      + " ORDER BY officeCode";

  private static final String QUERY_GET = "SELECT officeCode, city, phone, addressLine1,"
      + " addressLine2, state, country, postalCode, territory " //
      + " FROM offices"//
      + " WHERE officeCode = ?";

  private static final String QUERY_CREATE = "INSERT INTO offices (officeCode, city, phone, addressLine1,"
      + " addressLine2, state, country, postalCode, territory)" //
      + " VALUES(?,?,?,?,?,?,?,?,?)";

  private static final String QUERY_UPDATE = "UPDATE offices SET  city = ?, phone = ?, addressLine1 = ?,"
      + " addressLine2 = ?, state = ?, country = ?, postalCode = ?, territory = ?" //
      + " WHERE officeCode = ?";

  private static final String QUERY_DELETE = "DELETE FROM offices WHERE officeCode = ?";

  @Autowired
  private JdbcTemplate jdbcTemplate;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Office> findAll()
  {
    return this.jdbcTemplate.query( QUERY_FIND_ALL, new OfficeMapper() );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Office> findByTerritory( String territory )
  {
    return this.jdbcTemplate.query( QUERY_FIND_BY_TERRITORY, new Object[] { territory }, new OfficeMapper() );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Office get( String officeCode )
  {
    Office office = null;
    try
    {
      office = this.jdbcTemplate.queryForObject( QUERY_GET, new Object[] { officeCode }, new OfficeMapper() );
    }
    catch( EmptyResultDataAccessException e )
    {
      office = null;
    }
    return office;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void create( Office office )
  {

    if( this.get( office.getOfficeCode() ) == null )
    {
      this.jdbcTemplate.update(
        QUERY_CREATE,
        new Object[] { office.getOfficeCode(), office.getCity(), office.getPhone(), office.getAddressLine1(),
            office.getAddressLine2(), office.getState(), office.getCountry(), office.getPostalCode(),
            office.getTerritory() } );
    }
    else
    {
      throw new RuntimeException( "Ya existe el registro de la oficina " );
    }

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void edit( Office office )
  {
    if( this.get( office.getOfficeCode() ) != null )
    {
      this.jdbcTemplate.update(
        QUERY_UPDATE,
        new Object[] { office.getCity(), office.getPhone(), office.getAddressLine1(), office.getAddressLine2(),
            office.getState(), office.getCountry(), office.getPostalCode(), office.getTerritory(),
            office.getOfficeCode() } );
    }
    else
    {
      throw new RuntimeException( "No existe el registro de la oficina " );
    }

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete( String officeCode )
  {
    this.jdbcTemplate.update( QUERY_DELETE, new Object[] { officeCode } );

  }

}
