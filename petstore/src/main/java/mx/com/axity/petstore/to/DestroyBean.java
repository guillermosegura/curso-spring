package mx.com.axity.petstore.to;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;

public class DestroyBean implements DisposableBean
{
  private List<String> list;

  public DestroyBean()
  {
    System.out.println( "Constructor DestroyBean" );
  }

  @Override
  public void destroy() throws Exception
  {
    // Destroy
    System.out.println( "Invocando el método destroy DestroyBean" );
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
