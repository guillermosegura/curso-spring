package mx.com.axity.arquetipo.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.com.axity.arquetipo.commons.dto.CustomerDto;
import mx.com.axity.arquetipo.commons.request.PaginatedRequestDto;
import mx.com.axity.arquetipo.commons.response.PaginatedResponseDto;
import mx.com.axity.arquetipo.model.CustomerDO;
import mx.com.axity.arquetipo.persistence.CustomerPersistence;
import mx.com.axity.arquetipo.service.CustomerService;
import mx.com.axity.arquetipo.service.util.CustomerDtoTransformer;

/**
 * @author guillermo.segura@axity.com
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService
{

  @Autowired
  private CustomerPersistence customerPersistence;
  /**
   * {@inheritDoc}
   */
  @Override
  public PaginatedResponseDto<CustomerDto> findCustomers( PaginatedRequestDto request )
  {
    log.debug( null );
    int page = request.getOffset() / request.getLimit();
    Pageable pageRequest = PageRequest.of( page, request.getLimit(), Sort.by( "customerName", "country", "city" ) );

    var paged = this.customerPersistence.findAll( pageRequest );

    var result = new PaginatedResponseDto<CustomerDto>( page, request.getLimit(), paged.getTotalElements() );

    paged.stream().forEach( x -> result.getData().add( CustomerDtoTransformer.transform( x ) ) );

    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CustomerDto findCustomer( Long customerNumber )
  {
    var optional = this.customerPersistence.findById( customerNumber );
    CustomerDto result = null;
    if( optional.isPresent() )
    {
      result = CustomerDtoTransformer.transform( optional.get() );
    }
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public CustomerDto create( CustomerDto customer )
  {
    var entity = new CustomerDO();
    entity.setCustomerName( customer.getCustomerName() );
    entity.setContactFirstName( customer.getContactFirstName() );
    entity.setContactLastName( customer.getContactLastName() );
    entity.setCity( customer.getCity() );
    entity.setAddressLine1( customer.getAddressLine1() );
    entity.setAddressLine2( customer.getAddressLine2() );
    entity.setCountry( customer.getCountry() );
    entity.setCreditLimit( customer.getCreditLimit() );
    entity.setPhone( customer.getPhone() );
    entity.setPostalCode( customer.getPostalCode() );
    entity.setState( customer.getState() );

    var saved = this.customerPersistence.save( entity );
    customer.setCustomerNumber( saved.getCustomerNumber() );
    return customer;
  }

}
