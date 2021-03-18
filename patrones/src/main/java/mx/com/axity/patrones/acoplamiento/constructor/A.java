package mx.com.axity.patrones.acoplamiento.constructor;

public class A
{
  private B b;

  public A()
  {
    b = new B( 1, 2, 3, 4 );
  }

  public void task()
  {
    // doSomething
    b.task();
    // doSomethingElse
  }
}
