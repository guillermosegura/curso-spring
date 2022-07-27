package mx.com.axity.arquetipo.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.axity.arquetipo.commons.dto.CustomerDto;
import mx.com.axity.arquetipo.commons.request.PaginatedRequestDto;
import mx.com.axity.arquetipo.commons.response.GenericResponseDto;
import mx.com.axity.arquetipo.commons.response.PaginatedResponseDto;
import mx.com.axity.arquetipo.facade.CustomerFacade;
import mx.com.axity.arquetipo.service.CustomerService;

/**
 * @author guillermo.segura@axity.com
 */
@Service
public class CustomerFacadeImpl implements CustomerFacade
{
  @Autowired
  private CustomerService customerService;

  /**
   * {@inheritDoc}
   */
  @Override
  public PaginatedResponseDto<CustomerDto> findCustomers( PaginatedRequestDto request )
  {
    return this.customerService.findCustomers( request );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GenericResponseDto<CustomerDto> findCustomer( Long customerNumber )
  {
    return new GenericResponseDto<>( this.customerService.findCustomer( customerNumber ) );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public GenericResponseDto<CustomerDto> create( CustomerDto customer )
  {
    return new GenericResponseDto<>( this.customerService.create( customer ) );
  }

}
