package mx.com.axity.petstore.dao.impl;

import java.util.ArrayList;
import java.util.List;

import mx.com.axity.petstore.dao.AccountDao;
import mx.com.axity.petstore.to.Account;

public class AccountDaoImpl implements AccountDao
{

  @Override
  public List<Account> getAllAccounts()
  {
    List<Account> accounts = new ArrayList<Account>();
    for( int i = 0; i < 10; i++ )
    {
      int id = i + 1;
      Account account = createAccount( id );
      accounts.add( account );
    }
    return accounts;
  }

  @Override
  public Account getById( int id )
  {
    return createAccount( id );
  }

  private Account createAccount( int id )
  {
    Account account = new Account();
    account.setId( id );
    account.setUsername( "username " + id );
    return account;
  }

}
