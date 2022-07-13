package mx.com.axity.poc.to;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.SimpleLog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Data
{
  private static final Log LOG = new SimpleLog( "Data");
  
  private int id;
  private String name;
  private String lastname;

  private int[] values;
  private Map<Integer, String> map;
  private List<String> list;
  private Set<Integer> set;
  private Properties properties;

  public Data()
  {
  }

  public Data( int id )
  {
    this.id = id;
  }

  public Data( int id, String name, String lastname )
  {
    this.id = id;
    this.name = name;
    this.lastname = lastname;
  }

  public int getId()
  {
    return id;
  }

  public void setId( int id )
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

  public String getLastname()
  {
    return lastname;
  }

  public void setLastname( String lastname )
  {
    this.lastname = lastname;
  }



  public int[] getValues()
  {
    return values;
  }

  public void setValues( int[] values )
  {
    this.values = values;
  }

  public Map<Integer, String> getMap()
  {
    return map;
  }

  public void setMap( Map<Integer, String> map )
  {
    this.map = map;
  }

  public List<String> getList()
  {
    return list;
  }

  public void setList( List<String> list )
  {
    this.list = list;
  }

  public Set<Integer> getSet()
  {
    return set;
  }

  public void setSet( Set<Integer> set )
  {
    this.set = set;
  }

  public Properties getProperties()
  {
    return properties;
  }

  public void setProperties( Properties properties )
  {
    this.properties = properties;
  }
  
  @Override
  public String toString()
  {
    Gson gson = new GsonBuilder() .create();
    return gson.toJson( this );
  }
  
  
  @PostConstruct
  public void init(){
    LOG.info("Data creada");
  }

}
