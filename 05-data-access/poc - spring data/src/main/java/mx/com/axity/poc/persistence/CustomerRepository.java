package mx.com.axity.poc.persistence;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.axity.poc.entity.CustomerDO;
import mx.com.axity.poc.entity.PaymentDO;
import mx.com.axity.poc.entity.projection.CustomerPaymentProjection;
import mx.com.axity.poc.to.CustomerPayment;

/**
 * @author guillermo.segura@axity.com
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerDO, Long>
{

  List<CustomerDO> findByCustomerName( String customerName );

  @Query("SELECT o FROM CustomerDO o WHERE o.salesRepEmployee.employeeNumber = :employeeNumber")
  List<CustomerDO> findBySalesRepEmployee( @Param("employeeNumber") Long employeeNumber );

  List<CustomerDO> queryPorEstado( String state );

  /**
   * Busca clientes por estado y codigo postal
   * 
   * @param state
   * @param postalCode
   * @return
   */
  List<CustomerDO> queryPorEstadoCodigoPostal( @Param("estado") String state,
      @Param("codigoPostal") String postalCode );

  @Query("SELECT c.customerName as customerName," //
      + " c.contactLastName as contactLastName," //
      + " c.contactFirstName as contactFirstName," //
      + " c.phone as phone," //
      + " p.paymentDate as paymentDate," //
      + " p.amount as amount" //
      + " FROM PaymentDO p JOIN p.customer c" //
      + " WHERE c.customerNumber = :customerNumber ")
  List<CustomerPaymentProjection> findPaymentsByCustomer( @Param("customerNumber") Long customerNumber, Sort sort );
  
  @Query("SELECT new mx.com.axity.poc.to.CustomerPayment(c.customerName," //
    + " c.contactLastName," //
    + " c.contactFirstName," //
    + " c.phone," //
    + " p.paymentDate," //
    + " p.amount)" //
    + " FROM PaymentDO p JOIN p.customer c" //
    + " WHERE c.customerNumber = :customerNumber ")
  List<CustomerPayment> findPaymentsByCustomerConstructor( @Param("customerNumber") Long customerNumber, Sort sort );
  
  @Query("SELECT c.customerName," //
    + " c.contactLastName," //
    + " c.contactFirstName," //
    + " c.phone," //
    + " p.paymentDate," //
    + " p.amount" //
    + " FROM PaymentDO p JOIN p.customer c" //
    + " WHERE c.customerNumber = :customerNumber ")
  List<Object[]> findPaymentsByCustomerObjectArray( @Param("customerNumber") Long customerNumber, Sort sort );
  
  @Query("SELECT p FROM PaymentDO p JOIN p.customer c " //
      + " WHERE c.customerNumber = :customerNumber")
  List<PaymentDO> findPaymentsByCustomerEntity( @Param("customerNumber") Long customerNumber, Sort sort );
}
