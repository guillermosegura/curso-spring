package mx.com.axity.poc.dao.impl;

import com.google.gson.Gson;

import mx.com.axity.poc.dao.DataDAO;
import mx.com.axity.poc.to.Data;

public class DataDAOPro implements DataDAO
{

  public DataDAOPro()
  {
    System.out.println( "Crea el bean DataDAOPro" );
  }

  @Override
  public void insert( Data data )
  {
    System.out.println( "DataDAOPro" );
    StringBuilder sb = new StringBuilder();
    Gson gson = new Gson();
    sb.append( "Uso magia: " + gson.toJson( data ) );
    System.out.println( sb.toString() );
  }

}
