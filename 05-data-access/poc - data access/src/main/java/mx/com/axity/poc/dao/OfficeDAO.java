package mx.com.axity.poc.dao;

import java.util.List;

import mx.com.axity.poc.to.Office;

/**
 * Interface DAO para las oficina
 * 
 * @author guillermo.segura@axity.com
 */
public interface OfficeDAO
{

  /**
   * Busca los registros de la tabla offices
   * 
   * @return regresa la información
   */
  List<Office> findAll();

  /**
   * Busca los registros de la tabla offices por territorio
   * 
   * @param territory
   * @return
   */
  List<Office> findByTerritory( String territory );
  
  /**
   * Busca los registros de la tabla offices por territorio (lambda)
   * 
   * @param territory
   * @return
   */
  List<Office> findByTerritoryLambda( String territory );

  /**
   * Busca una oficina por su código en la tabla offices
   * 
   * @param officeCode
   * @return
   */
  Office get( String officeCode );

  /**
   * Crea un registro en la tabla offices
   * 
   * @param office
   */
  void create( Office office );

  /**
   * Edita un registro en la tabla offices
   * 
   * @param office
   */
  void edit( Office office );

  /**
   * Elimina un registro a partir de su código de oficina
   * 
   * @param officeCode
   */
  void delete( String officeCode );

}
