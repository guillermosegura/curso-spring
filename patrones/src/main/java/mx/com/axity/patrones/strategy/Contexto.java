package mx.com.axity.patrones.strategy;

public class Contexto
{
  private Aritmetica aritmetica;

  public Contexto( Aritmetica aritmetica )
  {
    this.aritmetica = aritmetica;
  }

  public int ejecuta( int a, int b )
  {
    return aritmetica.operacion( a, b );
  }
}
