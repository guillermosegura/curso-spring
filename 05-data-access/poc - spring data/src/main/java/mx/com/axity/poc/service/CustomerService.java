package mx.com.axity.poc.service;

import java.util.List;

import mx.com.axity.poc.to.Customer;
import mx.com.axity.poc.to.CustomerPayment;

/**
 * @author guillermo.segura@axity.com
 */
public interface CustomerService
{

  /**
   * Consulta todos los clientes
   * 
   * @return
   */
  List<Customer> findAll();

  /**
   * Consulta los clientes por estado
   * 
   * @param state
   * @return
   */
  List<Customer> findByState( String state );

  /**
   * Consulta los clientes por estado y código postal
   * 
   * @param state
   * @param postalCode
   * @return
   */
  List<Customer> findByStateAndPostalCode( String state, String postalCode );

  /**
   * Consulta los pagos por número de cliente
   * 
   * @param customerNumber
   * @return
   */
  List<CustomerPayment> findCustomerPayments( Long customerNumber );

}
