package mx.com.axity.poc.entity.transformer;

import mx.com.axity.poc.entity.OfficeDO;
import mx.com.axity.poc.to.Office;

import org.springframework.beans.BeanUtils;

public final class OfficeTransformer
{

  public static Office transform( OfficeDO entity )
  {
    Office to = null;
    if( entity != null )
    {
      to = new Office();
      BeanUtils.copyProperties( entity, to );
    }
    return to;
  }

  public static OfficeDO transform( Office to )
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
