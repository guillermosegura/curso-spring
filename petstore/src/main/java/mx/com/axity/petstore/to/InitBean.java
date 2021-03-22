package mx.com.axity.petstore.to;

import java.util.List;

import mx.com.axity.petstore.service.ProductorService;

import org.springframework.beans.factory.InitializingBean;

public class InitBean implements InitializingBean
{
  private List<String> list;

  private ProductorService productorService;

  public InitBean()
  {
    System.out.println( "Constructor InitBean" );

  }

  @Override
  public void afterPropertiesSet() throws Exception
  {
    list = productorService.getData();
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

  /**
   * @param productorService the productorService to set
   */
  public void setProductorService( ProductorService productorService )
  {
    System.out.println("Se pasa por referencia el bean ProductorService");
    this.productorService = productorService;
  }

}
