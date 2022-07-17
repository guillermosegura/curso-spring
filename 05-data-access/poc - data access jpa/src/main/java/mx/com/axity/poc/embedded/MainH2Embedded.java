package mx.com.axity.poc.embedded;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainH2Embedded
{

  public static void main( String[] args )
  {
    ApplicationContext context = new ClassPathXmlApplicationContext( "beans-h2embedded.xml" );

  }

}
