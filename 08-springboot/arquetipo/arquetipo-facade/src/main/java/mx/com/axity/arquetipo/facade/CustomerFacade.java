package mx.com.axity.arquetipo.facade;

import mx.com.axity.arquetipo.commons.dto.CustomerDto;
import mx.com.axity.arquetipo.commons.request.PaginatedRequestDto;
import mx.com.axity.arquetipo.commons.response.GenericResponseDto;
import mx.com.axity.arquetipo.commons.response.PaginatedResponseDto;

/**
 * @author guillermo.segura@axity.com
 */
public interface CustomerFacade
{
  /**
   * Consulta los clientes de manera paginada
   * 
   * @param limit
   * @param offset
   * @return
   */
  PaginatedResponseDto<CustomerDto> findCustomers( PaginatedRequestDto request );

  /**
   * Consulta un cliente por número
   * 
   * @param customerNumber
   * @return
   */
  GenericResponseDto<CustomerDto> findCustomer( Long customerNumber );

  /**
   * Alta de clientes
   * 
   * @param customer
   * @return
   */
  GenericResponseDto<CustomerDto> create( CustomerDto customer );
}
