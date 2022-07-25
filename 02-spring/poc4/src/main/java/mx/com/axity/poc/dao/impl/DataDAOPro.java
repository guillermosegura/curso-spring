package mx.com.axity.poc.dao.impl;

import mx.com.axity.poc.dao.DataDAO;
import mx.com.axity.poc.to.Data;

public class DataDAOPro implements DataDAO
{

  public DataDAOPro() {
    System.out.println( "Construyendo un DataDAOPro" );
  }
  
  @Override
  public void insert( Data data )
  {
    StringBuilder sb = new StringBuilder();
    sb.append( "DATADAOPRO :: INSERT INTO TBL_DATA (NAME, LASTNAME) VALUES (" );
    sb.append( "'" ).append( data.getName() ).append( "'," );
    sb.append( "'" ).append( data.getLastname() ).append( "');" );
    System.out.println( sb.toString() );
  }

}
