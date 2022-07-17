package mx.com.axity.poc.dao.impl;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import mx.com.axity.poc.dao.DataDAO;
import mx.com.axity.poc.to.Data;

@Repository
public class DataDAOImpl implements DataDAO
{
  private static final Log LOG = LogFactory.getLog( DataDAOImpl.class.getCanonicalName() );

  public DataDAOImpl()
  {
    LOG.info( "Creando instancia DataDAOImpl" );
  }

  @PostConstruct
  public void init()
  {
    LOG.info( "Llamando método init" );
  }

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
