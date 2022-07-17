package mx.com.axity.poc.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import mx.com.axity.poc.persistence.EmployeeRepository;
import mx.com.axity.poc.service.EmployeeService;
import mx.com.axity.poc.to.Employee;
import mx.com.axity.poc.util.EmployeeTransformer;

/**
 * @author guillermo.segura@axity.com
 */
public class EmployeeServiceImpl implements EmployeeService
{
  @Autowired
  private EmployeeRepository employeeRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Employee> findAll()
  {
    var employees = this.employeeRepository.findAll();

    return employees.stream().map( e -> EmployeeTransformer.transform( e ) ).collect( Collectors.toList() );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Employee> findByLastName( String lastName )
  {
    var employees = this.employeeRepository.findByLastName( lastName );

    return employees.stream().map( e -> EmployeeTransformer.transform( e ) ).collect( Collectors.toList() );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Employee findByEmail( String email )
  {
    var employee = this.employeeRepository.findByEmail( email );
    return EmployeeTransformer.transform( employee );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Employee> findByTerritory( String territory )
  {
    var employees = this.employeeRepository.findByOfficeTerritory( territory );
    return employees.stream().map( e -> EmployeeTransformer.transform( e ) ).collect( Collectors.toList() );
  }

}
