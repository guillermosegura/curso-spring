package mx.com.axity.poc.service.impl;

import mx.com.axity.poc.dao.DataDAO;
import mx.com.axity.poc.service.Service;
import mx.com.axity.poc.to.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ServiceImpl implements Service
{
  @Autowired
  @Qualifier("dataDAOPro")
  private DataDAO dataDAO;

  public ServiceImpl()
  {
    System.out.println( "Se construye ServiceImpl" );
  }

  @Override
  public void save( Data data )
  {
    this.dataDAO.insert( data );
  }

}
