package mx.com.axity.poc.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.TypedSort;

import mx.com.axity.poc.entity.PaymentDO;
import mx.com.axity.poc.entity.projection.CustomerPaymentProjection;
import mx.com.axity.poc.persistence.CustomerRepository;
import mx.com.axity.poc.service.CustomerService;
import mx.com.axity.poc.to.Customer;
import mx.com.axity.poc.to.CustomerPayment;
import mx.com.axity.poc.util.CustomerPaymentTransformer;
import mx.com.axity.poc.util.CustomerTransformer;

/**
 * @author guillermo.segura@axity.com
 */
public class CustomerServiceImpl implements CustomerService
{
  @Autowired
  private CustomerRepository customerRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Customer> findAll()
  {
    var customers = this.customerRepository.findAll();
    return customers.stream().map( e -> CustomerTransformer.transform( e ) ).collect( Collectors.toList() );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Customer> findByState( String state )
  {
    var customers = this.customerRepository.queryPorEstado( state );
    return customers.stream().map( e -> CustomerTransformer.transform( e ) ).collect( Collectors.toList() );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Customer> findByStateAndPostalCode( String state, String postalCode )
  {
    var customers = this.customerRepository.queryPorEstadoCodigoPostal( state, postalCode );
    return customers.stream().map( e -> CustomerTransformer.transform( e ) ).collect( Collectors.toList() );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<CustomerPayment> findCustomerPayments( Long customerNumber )
  {
    TypedSort<CustomerPaymentProjection> sort = Sort.sort( CustomerPaymentProjection.class );
    var customerPayments = this.customerRepository.findPaymentsByCustomer( customerNumber,
      Sort.by( "paymentDate" ).ascending() );

    return customerPayments.stream().map( e -> CustomerPaymentTransformer.transform( e ) )
        .collect( Collectors.toList() );
  }

}
