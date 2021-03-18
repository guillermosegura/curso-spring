package mx.com.axity.patrones.strategy;

public class Resta implements Aritmetica
{

  @Override
  public int operacion( int a, int b )
  {
    return a * b;
  }

}
