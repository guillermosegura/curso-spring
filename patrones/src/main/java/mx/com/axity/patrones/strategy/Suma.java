package mx.com.axity.patrones.strategy;

public class Suma implements Aritmetica
{

  @Override
  public int operacion( int a, int b )
  {
    return a + b;
  }

}
