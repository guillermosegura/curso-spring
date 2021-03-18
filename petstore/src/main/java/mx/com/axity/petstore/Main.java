package mx.com.axity.petstore;

import java.util.List;

import mx.com.axity.petstore.service.PetStoreService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{

  public static void main( String[] args )
  {

    ApplicationContext context = new ClassPathXmlApplicationContext( "services.xml", "daos.xml" );

    PetStoreService service = context.getBean( "petStore", PetStoreService.class );

    List<String> userList = service.getUsernameList();
    for( String user : userList )
    {
      System.out.println( user );
    }

  }

}
