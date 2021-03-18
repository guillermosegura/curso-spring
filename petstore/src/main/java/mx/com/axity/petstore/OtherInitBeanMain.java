package mx.com.axity.petstore;

import java.util.Collections;

import mx.com.axity.petstore.to.OtherInitBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OtherInitBeanMain
{

  public static void main( String[] args )
  {
    AbstractApplicationContext context = new ClassPathXmlApplicationContext( "otherinitbean.xml" );

    OtherInitBean otherInitBean = context.getBean( OtherInitBean.class );
    otherInitBean.getList().add( "manzana" );
    otherInitBean.getList().add( "pera" );
    otherInitBean.getList().add( "uva" );
    otherInitBean.getList().add( "canela" );
    otherInitBean.getList().add( "limón" );
    otherInitBean.getList().add( "manzanilla" );
    otherInitBean.getList().add( "chai" );
    Collections.sort( otherInitBean.getList() );

    for( String tea : otherInitBean.getList() )
    {
      System.out.println( tea );
    }
    context.registerShutdownHook();
  }

}
