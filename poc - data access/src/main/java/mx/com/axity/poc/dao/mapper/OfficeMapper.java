package mx.com.axity.poc.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import mx.com.axity.poc.to.Office;

import org.springframework.jdbc.core.RowMapper;

/**
 * Classe mapper de la tabla offices a un {@link mx.com.axity.poc.to.Office}
 * 
 * @author guillermo.segura@axity.com
 */
public final class OfficeMapper implements RowMapper<Office>
{

  /**
   * {@inheritDoc}
   */
  @Override
  public Office mapRow( ResultSet rs, int rowNum ) throws SQLException
  {
    Office office = new Office();
    office.setOfficeCode( rs.getString( "officeCode" ) );
    office.setCity( rs.getString( "city" ) );
    office.setPhone( rs.getString( "phone" ) );
    office.setAddressLine1( rs.getString( "addressLine1" ) );
    office.setAddressLine2( rs.getString( "addressLine2" ) );
    office.setState( rs.getString( "state" ) );
    office.setCountry( rs.getString( "country" ) );
    office.setPostalCode( rs.getString( "postalCode" ) );
    office.setTerritory( rs.getString( "territory" ) );
    return office;
  }

}
