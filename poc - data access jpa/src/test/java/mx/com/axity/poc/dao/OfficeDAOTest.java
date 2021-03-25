package mx.com.axity.poc.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import mx.com.axity.poc.entity.EmployeeDO;
import mx.com.axity.poc.entity.OfficeDO;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration({ "classpath:/beans.xml" })
@Transactional
public class OfficeDAOTest
{
  private static final Logger LOG = LoggerFactory.getLogger( OfficeDAOTest.class );

  @Autowired
  private OfficeDAO officeDAO;

  @Autowired
  private EmployeeDAO employeeDAO;

  @Test
  public void testFindAll()
  {
    List<OfficeDO> offices = officeDAO.findAll();

    Assert.assertNotNull( offices );
    Assert.assertFalse( offices.isEmpty() );

    for( OfficeDO office : offices )
    {
      log( office );
    }
  }

  @Test
  public void testFindByTerritory()
  {
    List<OfficeDO> offices = officeDAO.findByTerritory( "NA" );

    Assert.assertNotNull( offices );
    Assert.assertFalse( offices.isEmpty() );

    for( OfficeDO office : offices )
    {
      log( office );
    }
  }

  @Test
  public void testGet()
  {
    OfficeDO office = this.officeDAO.get( "1" );
    Assert.assertNotNull( office );
    log( office );
  }

  @Test
  public void testGet_notFound()
  {
    OfficeDO office = this.officeDAO.get( "99999" );
    Assert.assertNull( office );
  }

  @Test
  public void testCreate()
  {
    OfficeDO office = new OfficeDO();
    office.setOfficeCode( "8" );
    office.setCity( "CDMX" );
    office.setPhone( "+52 55 50 46 92 00" );
    office.setAddressLine1( "Av Ejército Nacional 350," );
    office.setAddressLine2( "piso 5 Polanco V Sección" );
    office.setState( "CDMX" );
    office.setCountry( "México" );
    office.setPostalCode( "11560" );
    office.setTerritory( "LATAM" );
    this.officeDAO.create( office );

    office = this.officeDAO.get( "8" );
    Assert.assertNotNull( office );

    log( office );
  }

  @Test
  public void testEdit()
  {
    OfficeDO office = new OfficeDO();
    office.setOfficeCode( "1" );
    office.setCity( "CDMX" );
    office.setPhone( "+52 55 50 46 92 00" );
    office.setAddressLine1( "Av Ejército Nacional 350," );
    office.setAddressLine2( "piso 5 Polanco V Sección" );
    office.setState( "CDMX" );
    office.setCountry( "México" );
    office.setPostalCode( "11560" );
    office.setTerritory( "LATAM" );
    this.officeDAO.edit( office );

    office = this.officeDAO.get( "1" );
    Assert.assertNotNull( office );
    log( office );
  }

  @Test(expected = PersistenceException.class)
  public void testDelete_PersistenceException_FK_Referenced()
  {
    this.officeDAO.delete( "1" );
  }

  @Test
  public void testDelete_notFound()
  {
    this.officeDAO.delete( "9999" );
  }

  @Test
  public void testDelete()
  {
    OfficeDO office = new OfficeDO();
    office.setOfficeCode( "9" );
    office.setCity( "Puebla" );
    office.setPhone( "+52 22 22 33 40 30" );
    office.setAddressLine1( "25 de Noviembre 5906," );
    office.setAddressLine2( "San Baltazar Campeche" );
    office.setState( "Puebla" );
    office.setCountry( "México" );
    office.setPostalCode( "72550" );
    office.setTerritory( "LATAM" );

    this.officeDAO.create( office );
    this.officeDAO.delete( "9" );
  }

  @Test
  public void testAddEmployee()
  {
    EmployeeDO employee = employeeDAO.get( 1188L );

    this.officeDAO.addEmployee( "1", employee );
  }

  @Test(expected = RuntimeException.class)
  public void testAddEmployee_employeeAlreadyAssignedToOffice()
  {
    EmployeeDO employee = employeeDAO.get( 1076L );

    this.officeDAO.addEmployee( "1", employee );
  }

  @Test(expected = RuntimeException.class)
  public void testAddEmployee_officeNotFound()
  {
    EmployeeDO employee = employeeDAO.get( 1188L );

    this.officeDAO.addEmployee( "9999", employee );
  }
  
  
  @Test
  public void testRemoveEmployee(){
    EmployeeDO employee = employeeDAO.get( 1188L );
    this.officeDAO.removeEmployee( "2", employee );
  }
  
  @Test(expected=RuntimeException.class)
  public void testRemoveEmployee_officeNotFound(){
    EmployeeDO employee = employeeDAO.get( 1188L );
    this.officeDAO.removeEmployee( "9999", employee );
  }
  
  @Test(expected=RuntimeException.class)
  public void testRemoveEmployee_employeeNotAssigned(){
    EmployeeDO employee = employeeDAO.get( 1188L );
    this.officeDAO.removeEmployee( "3", employee );
  }

  private void log( OfficeDO office )
  {
    LOG.info( "{}.{},{}", office.getOfficeCode(), office.getCity(), office.getCountry() );
  }
}
