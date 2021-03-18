package mx.com.axity.petstore;

import mx.com.axity.petstore.to.DestroyBean;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DisposableBeanMain
{

  public static void main( String[] args )
  {
    AbstractApplicationContext  context = new ClassPathXmlApplicationContext( "disposablebean.xml" );

    DestroyBean destroyBean = context.getBean( DestroyBean.class );

    context.registerShutdownHook();
  }

}
