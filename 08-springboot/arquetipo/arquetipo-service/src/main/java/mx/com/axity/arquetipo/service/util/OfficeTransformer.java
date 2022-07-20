package mx.com.axity.arquetipo.service.util;

import mx.com.axity.arquetipo.commons.dto.OfficeDto;
import mx.com.axity.arquetipo.model.OfficeDO;

/**
 * @author guillermo.segura@axity.com
 */
public final class OfficeTransformer
{
  private OfficeTransformer()
  {
  }

  public static OfficeDto transform( OfficeDO entity )
  {
    OfficeDto office = null;
    
    if( entity != null )
    {
      office = new OfficeDto();
      office.setOfficeCode( entity.getOfficeCode() );
      office.setCountry( entity.getCountry() );
    }
    return office;
  }
}
