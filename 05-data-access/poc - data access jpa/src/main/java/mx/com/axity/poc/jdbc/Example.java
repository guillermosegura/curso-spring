package mx.com.axity.poc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Example
{

  private Connection getConnection()
  {
    Connection conn = null;

    String url = "jdbc:mysql://localhost:3306";
    try
    {
      conn = DriverManager.getConnection( url );
    }
    catch( SQLException e )
    {
      // manejar excepciones
    }

    return conn;
  }

  public List<Catalog> getCatalogs()
  {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<Catalog> catalogs = null;
    try
    {
      conn = getConnection();
      String query = "SELECT ID, NAME FROM CATALOG ORDER BY ID";
      ps = conn.prepareStatement( query );
      rs = ps.executeQuery();

      catalogs = new ArrayList<Catalog>();
      while( rs.next() )
      {
        Catalog catalog = new Catalog();
        catalog.setId( rs.getInt( "ID" ) );
        catalog.setName( rs.getString( "NAME" ) );
        catalogs.add( catalog );
      }
    }
    catch( SQLException e )
    {
      // manejar excepciones
    }
    finally
    {
      // Cerrar Connection, ResultSet y PreparedStatement
    }
    return catalogs;
  }

}
