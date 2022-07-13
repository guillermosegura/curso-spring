package mx.com.axity.poc.controller;

import mx.com.axity.poc.dao.DataDAO;
import mx.com.axity.poc.dao.impl.DataDAOImpl;
import mx.com.axity.poc.service.Service;
import mx.com.axity.poc.service.impl.ServiceImpl;
import mx.com.axity.poc.to.Data;

/**
 * Clase controlador
 * 
 * @author guillermo.segura@axity.com
 */
public class Controller
{

  private Service service;

  /**
   * Constructor default
   */
  public Controller()
  {
    service = new ServiceImpl();
    DataDAO dataDAO = new DataDAOImpl();
    ((ServiceImpl) service).setDataDAO( dataDAO );
  }

  /**
   * Método para guarda la data
   * 
   * @param data información a guardar
   */
  public void save( Data data )
  {
    service.save( data );
  }

}
