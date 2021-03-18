package mx.com.axity.petstore.to;

import java.util.ArrayList;
import java.util.List;

public class OtherInitBean
{
  private List<String> list;

  public OtherInitBean()
  {
    System.out.println( "Constructor OtherInitBean" );
  }

  public void init()
  {
    list = new ArrayList<String>();
    System.out.println( "init OtherInitBean" );
  }

  public List<String> getList()
  {
    return list;
  }

  public void setList( List<String> list )
  {
    this.list = list;
  }

  public void destroy()
  {
    System.out.println( "destroy OtherInitBean" );
  }

}
