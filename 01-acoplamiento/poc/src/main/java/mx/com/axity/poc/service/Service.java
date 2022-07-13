package mx.com.axity.poc.service;

import mx.com.axity.poc.to.Data;

/**
 * Interface de servicio
 * 
 * @author guillermo.segura@axity.com
 */
public interface Service
{
  /**
   * Guarda la información
   * 
   * @param data
   */
  void save( Data data );
}
