package mx.com.axity.petstore.service;

import java.util.List;

import mx.com.axity.petstore.to.Item;

public interface PetStoreService
{

  List<String> getUsernameList();
  
  List<Item> getItemList();
}
