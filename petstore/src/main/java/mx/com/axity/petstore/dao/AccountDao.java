package mx.com.axity.petstore.dao;

import java.util.List;

import mx.com.axity.petstore.to.Account;

public interface AccountDao
{

  List<Account> getAllAccounts();

  Account getById( int id );
}
