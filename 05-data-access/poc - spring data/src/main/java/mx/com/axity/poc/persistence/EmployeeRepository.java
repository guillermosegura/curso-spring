package mx.com.axity.poc.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.axity.poc.entity.EmployeeDO;

/**
 * @author guillermo.segura@axity.com
 */
public interface EmployeeRepository extends JpaRepository<EmployeeDO, Long>
{

  /**
   * Busca los empleados por apellido
   * 
   * @param lastName
   * @return
   */
  List<EmployeeDO> findByLastName( String lastName );

  /**
   * Busca un empleado por su correo
   * 
   * @param email
   * @return
   */
  EmployeeDO findByEmail( String email );

  /**
   * Busca los empleados por territorio de la oficina
   * 
   * @param territory
   * @return
   */
  List<EmployeeDO> findByOfficeTerritory( String territory );
}
