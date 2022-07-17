package mx.com.axity.poc.service;

import java.util.List;

import mx.com.axity.poc.to.Office;

/**
 * Servicio de oficinas
 * 
 * @author shama
 */
public interface OfficeService
{
  /**
   * Busca todas las oficinas
   * 
   * @return
   */
  List<Office> findAll();

  /**
   * Busca las oficinas por territorio
   * 
   * @param territory
   * @return
   */
  List<Office> findByTerritory( String territory );
  
  /**
   * Busca las oficinas por territorio
   * 
   * @param territory
   * @return
   */
  List<Office> findByTerritoryLambda( String territory );

  /**
   * Busca una oficina por su código
   * 
   * @param officeCode
   * @return
   */
  Office get( String officeCode );

  /**
   * Crea una oficina
   * 
   * @param office
   */
  void create( Office office );

  /**
   * Actualiza una oficina
   * 
   * @param office
   */
  void edit( Office office );

  /**
   * Elimina un registro de oficina
   * 
   * @param officeCode
   */
  void delete( String officeCode );
}
