package mx.com.axity.poc.dao;

import java.util.List;

import mx.com.axity.poc.entity.CustomerDO;
import mx.com.axity.poc.entity.PaymentDO;

/**
 * Interface DAO para
 * 
 * @author guillermo.segura@axity.com
 */
public interface CustomerDAO
{

  /**
   * Obtiene todos los clientes
   * 
   * @return
   */
  List<CustomerDO> findAll();

  /**
   * Busca los clientes por su nombre
   * 
   * @param customerName
   * @return
   */
  List<CustomerDO> findByCustomerName( String customerName );

  /**
   * Busca los clientes por el id del empleado asignado como representante de ventas
   * 
   * @param employeeNumber
   * @return
   */
  List<CustomerDO> findBySalesRepEmployee( Long employeeNumber );

  /**
   * Busca un cliente porsu id
   * 
   * @param customerNumber
   * @return
   */
  CustomerDO get( Long customerNumber );

  /**
   * Crea un cliente
   * 
   * @param customer
   */
  void create( CustomerDO customer );

  /**
   * Edita un cliente
   * 
   * @param customer
   */
  void edit( CustomerDO customer );

  /**
   * Elimina un cliente
   * 
   * @param customerNumber
   */
  void delete( Long customerNumber );

}
