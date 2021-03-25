package mx.com.axity.poc.dao.impl;

import java.net.MalformedURLException;
import java.net.URL;

import mx.com.axity.poc.dao.DataDAO;
import mx.com.axity.poc.to.Data;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class DataDAOImpl implements DataDAO
{
  private static final Logger LOG = Logger.getLogger(DataDAOImpl.class);
  @Override
  public void insert( Data data )
  {
    StringBuilder sb = new StringBuilder();
    sb.append( "INSERT INTO TBL_DATA (NAME, LASTNAME) VALUES (" );
    sb.append( "'" ).append( data.getName() ).append( "'," );
    sb.append( "'" ).append( data.getLastname() ).append( "');" );
    LOG.info( sb.toString() );
    
    try
    {
     URL url = new URL( "ahtml;//www.google.com" ); 
    }
    catch( RuntimeException e )
    {
      LOG.error( e.getMessage(), e );
    }
    catch( MalformedURLException e )
    {
      // TODO Auto-generated catch block
      //e.printStackTrace();
      LOG.error( e.getMessage(), e );
    }
  }

}
