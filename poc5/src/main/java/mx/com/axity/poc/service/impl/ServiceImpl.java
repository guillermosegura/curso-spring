package mx.com.axity.poc.service.impl;

import javax.annotation.PostConstruct;

import mx.com.axity.poc.dao.DataDAO;
import mx.com.axity.poc.service.Service;
import mx.com.axity.poc.to.Data;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.SimpleLog;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service
{
  private static final Log LOG = new SimpleLog( "ServiceImpl" );

  @Autowired
  private DataDAO dataDAO;

  public ServiceImpl()
  {
    LOG.info( "Creando instancia ServiceImpl" );
  }
  
  @PostConstruct
  public void init()
  {
    LOG.info( "Llamando método init" );
  }

  @Override
  public void save( Data data )
  {
    this.dataDAO.insert( data );
  }

}
