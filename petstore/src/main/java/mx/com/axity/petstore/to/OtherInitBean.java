package mx.com.axity.petstore.to;

import java.util.ArrayList;
import java.util.List;

import mx.com.axity.petstore.service.ProductorService;

public class OtherInitBean
{
  private List<String> list;

  private ProductorService productorService;

  public OtherInitBean()
  {
    System.out.println( "Constructor OtherInitBean" );
  }

  public void init()
  {
    list = productorService.getData();
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

  /**
   * @param productorService the productorService to set
   */
  public void setProductorService( ProductorService productorService )
  {
    System.out.println("Se inyecta el servicio ProductorService");
    this.productorService = productorService;
  }

}
