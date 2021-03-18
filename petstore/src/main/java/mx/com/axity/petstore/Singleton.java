package mx.com.axity.petstore;

import mx.com.axity.petstore.to.Item;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Singleton
{

  public static void main( String[] args )
  {
    ApplicationContext context = new ClassPathXmlApplicationContext( "beans-scope-singleton.xml" );

    Item item1 = context.getBean( "item", Item.class );
    item1.setId( 1 );
    item1.setDescription( "Taza" );
    item1.setSku( "6500110001" );

    Item item2 = context.getBean( "item", Item.class );
    item2.setId( 2 );
    item2.setDescription( "Vaso" );
    item2.setSku( "6500110002" );

    print(item1);
    print(item2);
  }

  private static void print( Item item )
  {
    System.out.println( String.format( "{ \"id\": %d, \"sku\": \"%s\", \"description\": \"%s\" } ", item.getId(),
      item.getDescription(), item.getSku() ) );
  }
}
