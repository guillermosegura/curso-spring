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
