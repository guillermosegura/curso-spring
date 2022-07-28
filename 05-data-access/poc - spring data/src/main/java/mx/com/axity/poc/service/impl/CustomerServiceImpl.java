package mx.com.axity.poc.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.TypedSort;
import org.springframework.transaction.annotation.Transactional;

import mx.com.axity.poc.aop.Intercept;
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
@Intercept
@Transactional
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

  /**
   * {@inheritDoc}
   */
  @Override
  public List<CustomerPayment> findCustomerPaymentsConstructor( Long customerNumber )
  {
    Sort sort = Sort.by( "paymentDate" );
    return this.customerRepository.findPaymentsByCustomerConstructor( customerNumber, sort );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<CustomerPayment> findCustomerPaymentsObjectArray( Long customerNumber )
  {
    Sort sort = Sort.by( "paymentDate" );
    
    List<Object[]> result = this.customerRepository.findPaymentsByCustomerObjectArray( customerNumber, sort );
    return result.stream().map( o -> {
      var cp = new CustomerPayment();
      cp.setCustomerName( (String) o[0] );
      cp.setContactLastName( (String) o[1] );
      cp.setContactFirstName( (String) o[2]  );
      cp.setPhone( (String) o[3] );
      cp.setPaymentDate( (Date) o[4] );
      cp.setAmount( new BigDecimal( o[5].toString() ) );
      return cp;
    }).collect( Collectors.toList() );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<CustomerPayment> findCustomerPaymentsEntity( Long customerNumber )
  {
    Sort sort = Sort.by( "paymentDate" );
    return this.customerRepository.findPaymentsByCustomerEntity(customerNumber, sort)
        .stream().map( p -> {
          var cp = new CustomerPayment();
          cp.setCustomerName( p.getCustomer().getCustomerName() );
          cp.setContactLastName( p.getCustomer().getContactLastName() );
          cp.setContactFirstName( p.getCustomer().getContactFirstName()  );
          cp.setPhone( p.getCustomer().getPhone() );
          cp.setPaymentDate( p.getPaymentDate() );
          cp.setAmount( p.getAmount() );
          return cp;
        }).collect( Collectors.toList() );
  }

}
