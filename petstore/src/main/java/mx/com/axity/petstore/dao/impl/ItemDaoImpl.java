package mx.com.axity.petstore.dao.impl;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import mx.com.axity.petstore.dao.ItemDao;
import mx.com.axity.petstore.to.Item;

public class ItemDaoImpl implements ItemDao
{

  @Override
  public List<Item> getAllItems()
  {
    List<Item> items = new ArrayList<Item>();
    for( int i = 0; i < 10; i++ )
    {
      int id = i + 1;
      Item item = createItem( id );
      items.add( item );
    }
    return items;
  }

  @Override
  public Item getById( int id )
  {
    return createItem( id );
  }

  private Item createItem( int id )
  {
    Item item = new Item();
    item.setId( id );
    item.setDescription( "Item " + id );
    
    NumberFormat df = new DecimalFormat( "000000000" );
    int sku  = (int) (Math.random()* 1000000000);
    item.setSku( df.format( sku )  );
    return item;
  }
}
