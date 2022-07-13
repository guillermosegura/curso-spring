package mx.com.axity.poc;

import mx.com.axity.poc.controller.Controller;
import mx.com.axity.poc.to.Data;

/**
 * Clase principal
 * 
 * @author guillermo.segura@axity.com
 */
public class Main
{
  /**
   * Método main
   * 
   * @param args
   */
  public static void main( String[] args )
  {
    Controller controller = new Controller();

    Data data = new Data();
    data.setName( args[0] );
    data.setLastname( args[1] );
    controller.save( data );
  }
}
