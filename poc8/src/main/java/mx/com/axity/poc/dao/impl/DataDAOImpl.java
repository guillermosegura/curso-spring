package mx.com.axity.poc.dao.impl;

import mx.com.axity.poc.dao.DataDAO;
import mx.com.axity.poc.to.Data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DataDAOImpl implements DataDAO
{
  private static final Logger LOG = LoggerFactory.getLogger( DataDAOImpl.class );

  @Override
  public void insert( Data data )
  {
    StringBuilder sb = new StringBuilder();
    sb.append( "INSERT INTO TBL_DATA (NAME, LASTNAME) VALUES (" );
    sb.append( "'" ).append( data.getName() ).append( "'," );
    sb.append( "'" ).append( data.getLastname() ).append( "');" );
    LOG.info( sb.toString() );
  }

}
