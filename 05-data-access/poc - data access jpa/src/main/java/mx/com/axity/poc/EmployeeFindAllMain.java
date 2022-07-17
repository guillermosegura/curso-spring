package mx.com.axity.poc;

import java.util.List;

import mx.com.axity.poc.dao.EmployeeDAO;
import mx.com.axity.poc.entity.EmployeeDO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EmployeeFindAllMain
{
  private static final Logger LOG = LoggerFactory.getLogger( EmployeeFindAllMain.class );

  public static void main( String[] args )
  {
    ApplicationContext context = new ClassPathXmlApplicationContext( "beans-h2embedded.xml" );

    EmployeeDAO dao = context.getBean( EmployeeDAO.class );
    var employees = dao.findAll();
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    for( EmployeeDO employee : employees )
    {

      LOG.info( "{} - {}, {} <{}> {} [{}]", employee.getEmployeeNumber(), employee.getLastName(),
        employee.getFirstName(), employee.getEmail(), employee.getJobTitle(), employee.getOffice().getCountry() );
    }

    // OfficeService officeService = context.getBean( OfficeService.class );
    // List<Office> offices = officeService.findAll();
    //
    // for( Office office : offices )
    // {
    // LOG.info( "{}", office );
    // }

  }
}
