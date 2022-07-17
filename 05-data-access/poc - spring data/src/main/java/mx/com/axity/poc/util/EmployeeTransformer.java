package mx.com.axity.poc.util;

import mx.com.axity.poc.entity.EmployeeDO;
import mx.com.axity.poc.to.Employee;

/**
 * @author guillermo.segura@axity.com
 */
public final class EmployeeTransformer
{
  private EmployeeTransformer()
  {
  }

  /**
   * Convierte una entidad {@link mx.com.axity.poc.entity.EmployeeDO} en {@link mx.com.axity.poc.to.Employee}
   * 
   * @param e
   * @return
   */
  public static Employee transform( EmployeeDO e )
  {
    Employee employee = null;
    if( e != null )
    {
      employee = new Employee();
      employee.setEmail( e.getEmail() );
      employee.setEmployeeNumber( e.getEmployeeNumber() );
      employee.setExtension( e.getExtension() );
      employee.setFirstName( e.getFirstName() );
      employee.setJobTitle( e.getJobTitle() );
      employee.setLastName( e.getLastName() );
      employee.setOfficeCode( e.getOffice().getOfficeCode() );
      if( e.getReportsTo() != null )
      {
        employee.setReportsTo( e.getReportsTo().getEmployeeNumber() );
      }
    }

    return employee;
  }
}
