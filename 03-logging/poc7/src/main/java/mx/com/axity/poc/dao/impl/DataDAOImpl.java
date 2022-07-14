package mx.com.axity.poc.dao.impl;

import mx.com.axity.poc.dao.DataDAO;
import mx.com.axity.poc.to.Data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class DataDAOImpl implements DataDAO
{
  private static final Logger LOG = LogManager.getLogger(DataDAOImpl.class);
  @Override
  public void insert( Data data )
  {
    StringBuilder sb = new StringBuilder();
    sb.append( "INSERT INTO TBL_DATA (NAME, LASTNAME) VALUES (" );
    sb.append( "'" ).append( data.getName() ).append( "'," );
    sb.append( "'" ).append( data.getLastname() ).append( "');" );
    LOG.debug( sb.toString() );
    
    
    try
    {
      int n = 1 / 0;
    }
    catch( RuntimeException e )
    {
      LOG.error( e.getMessage(), e );
    }
  }

}
