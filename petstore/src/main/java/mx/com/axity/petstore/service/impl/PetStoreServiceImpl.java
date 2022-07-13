package mx.com.axity.petstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import mx.com.axity.petstore.dao.AccountDao;
import mx.com.axity.petstore.dao.ItemDao;
import mx.com.axity.petstore.service.PetStoreService;
import mx.com.axity.petstore.to.Account;
import mx.com.axity.petstore.to.Item;

public class PetStoreServiceImpl implements PetStoreService
{

  private ItemDao itemDao;
  private AccountDao accountDao;

  public PetStoreServiceImpl()
  {
    System.out.println( "Constructor PetStoreServiceImpl" );
  }

  public PetStoreServiceImpl( int n )
  {
    System.out.println( "Constructor PetStoreServiceImpl: " + n );
  }

  public PetStoreServiceImpl( A a )
  {
    System.out.println( "Constructor PetStoreServiceImpl: " + a.getId() );
  }

  public void init()
  {
    System.out.println( "Se ha creado el Bean, iniciando..." );
  }

  @Override
  public List<String> getUsernameList()
  {
    List<Account> accounts = this.accountDao.getAllAccounts();
    List<String> list = new ArrayList<String>( accounts.size() );
    for( Account account : accounts )
    {
      list.add( account.getUsername() );
    }
    return list;
  }

  @Override
  public List<Item> getItemList()
  {
    // TODO Auto-generated method stub
    return null;
  }

  public void setItemDao( ItemDao itemDao )
  {
    this.itemDao = itemDao;
  }

  public void setAccountDao( AccountDao accountDao )
  {
    this.accountDao = accountDao;
  }

}
