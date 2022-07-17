package mx.com.axity.poc.service;

import java.util.List;

import mx.com.axity.poc.to.Employee;

/**
 * @author guillermo.segura@axity.com
 */
public interface EmployeeService
{

  /**
   * Busca todos los empleados
   * 
   * @return
   */
  List<Employee> findAll();

  /**
   * Busca los empleados por apellido
   * 
   * @param lastName
   * @return
   */
  List<Employee> findByLastName( String lastName );

  /**
   * Busca un empleado por correo electrónico
   * 
   * @param email
   * @return
   */
  Employee findByEmail( String email );

  /**
   * Busca los empleados por territorio
   * 
   * @param territory
   * @return
   */
  List<Employee> findByTerritory( String territory );
}
