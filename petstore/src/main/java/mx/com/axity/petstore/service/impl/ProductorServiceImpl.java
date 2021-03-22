package mx.com.axity.petstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import mx.com.axity.petstore.service.ProductorService;

public class ProductorServiceImpl implements ProductorService
{
  
  public ProductorServiceImpl(){
    System.out.println("Constructor ProductorServiceImpl");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<String> getData()
  {
    List<String> list = new ArrayList<String>();
    list.add( "auto" );
    list.add( "camión" );
    list.add( "camioneta" );
    list.add( "avioneta" );
    list.add( "barco" );

    return list;
  }

}
