package mx.com.axity.poc.dao.impl;

import mx.com.axity.poc.dao.DataDAO;
import mx.com.axity.poc.to.Data;

public class DataDAOImpl implements DataDAO
{
  public DataDAOImpl()
  {
    System.out.println( "Se crea DataDAOImpl" );
  }

  public DataDAOImpl( int n )
  {
    System.out.println( "Crea el bean DataDAOImpl N:" + n );
  }

  @Override
  public void insert( Data data )
  {
    System.out.println( "DataDAOImpl" );
    StringBuilder sb = new StringBuilder();
    sb.append( "INSERT INTO TBL_DATA (NAME, LASTNAME) VALUES (" );
    sb.append( "'" ).append( data.getName() ).append( "'," );
    sb.append( "'" ).append( data.getLastname() ).append( "');" );
    System.out.println( sb.toString() );
  }

}
