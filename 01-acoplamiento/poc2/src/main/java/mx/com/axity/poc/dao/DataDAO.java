package mx.com.axity.poc.dao;

import mx.com.axity.poc.to.Data;

/**
 * Interface DAO
 * 
 * @author guillermo.segura@axity.com
 */
public interface DataDAO
{
  /**
   * Guarda la información
   * 
   * @param data
   */
  void insert( Data data );
}
