package mx.com.axity.petstore.dao;

import java.util.List;

import mx.com.axity.petstore.to.Item;

public interface ItemDao
{
  List<Item> getAllItems();

  Item getById( int id );
}
