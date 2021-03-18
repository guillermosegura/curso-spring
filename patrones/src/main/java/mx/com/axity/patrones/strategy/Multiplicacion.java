package mx.com.axity.patrones.strategy;

public class Multiplicacion implements Aritmetica
{

  @Override
  public int operacion( int a, int b )
  {
    return a * b;
  }

}
