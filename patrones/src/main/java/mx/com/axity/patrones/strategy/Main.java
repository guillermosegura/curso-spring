package mx.com.axity.patrones.strategy;

public class Main
{

  public static void main( String[] args )
  {
    int a = 10;
    int b = 5;

    Contexto contexto = new Contexto( new Suma() );
    System.out.println( "10 + 5 = " + contexto.ejecuta( a, b ) );

    contexto = new Contexto( new Resta() );
    System.out.println( "10 - 5 = " + contexto.ejecuta( a, b ) );

    contexto = new Contexto( new Multiplicacion() );
    System.out.println( "10 * 5 = " + contexto.ejecuta( a, b ) );

  }

}
