package mx.com.axity.poc.service.impl;

import mx.com.axity.poc.dao.DataDAO;
import mx.com.axity.poc.service.Service;
import mx.com.axity.poc.to.Data;

public class ServiceImpl implements Service
{

  private DataDAO dataDAO;

  public ServiceImpl()
  {
  }

  public ServiceImpl( DataDAO dataDAO )
  {
    this.dataDAO = dataDAO;
  }

  @Override
  public void save( Data data )
  {
    this.dataDAO.insert( data );
  }

  public void setDataDAO( DataDAO dataDAO )
  {
    this.dataDAO = dataDAO;
  }

}
