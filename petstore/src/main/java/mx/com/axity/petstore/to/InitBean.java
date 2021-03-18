package mx.com.axity.petstore.to;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;

public class InitBean implements InitializingBean
{
  private List<String> list;
  
  public InitBean()
  {
    System.out.println( "Constructor InitBean" );
  }

  @Override
  public void afterPropertiesSet() throws Exception
  {
    list = new ArrayList<String>();
    System.out.println( "afterPropertiesSet InitBean" );
  }

  public List<String> getList()
  {
    return list;
  }

  public void setList( List<String> list )
  {
    this.list = list;
  }

}
