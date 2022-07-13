package mx.com.axity.poc.dao.impl;

import mx.com.axity.poc.dao.DataDAO;
import mx.com.axity.poc.to.Data;

/**
 * Clase que implementa la interface {@link mx.com.axity.poc.dao.DataDAO}
 * 
 * @author guillermo.segura@axity.com
 */
public class DataDAOImpl implements DataDAO
{

  /**
   * {@inheritDoc}
   */
  @Override
  public void insert( Data data )
  {
    StringBuilder sb = new StringBuilder();
    sb.append( "INSERT INTO TBL_DATA (NAME, LASTNAME) VALUES (" );
    sb.append( "'" ).append( data.getName() ).append( "'," );
    sb.append( "'" ).append( data.getLastname() ).append( "');" );
    System.out.println( sb.toString() );
  }

}
