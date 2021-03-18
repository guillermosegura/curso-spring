package mx.com.axity.petstore;

import java.util.Collections;

import mx.com.axity.petstore.to.InitBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitializingBeanMain
{

  public static void main( String[] args )
  {
    ApplicationContext context = new ClassPathXmlApplicationContext( "initbean.xml" );

    InitBean initBean = context.getBean( InitBean.class );
    initBean.getList().add( "manzana" );
    initBean.getList().add( "pera" );
    initBean.getList().add( "uva" );
    initBean.getList().add( "canela" );
    initBean.getList().add( "limón" );
    initBean.getList().add( "manzanilla" );
    initBean.getList().add( "chai" );
    Collections.sort( initBean.getList() );

    for( String tea : initBean.getList() )
    {
      System.out.println( tea );
    }

  }

}
