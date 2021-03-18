package mx.com.axity.patrones.acoplamiento.subclase;

public class A
{
  private B b;

  public A()
  {
    // Uso la clase padre B ¿?
    b = new B(  );
    // Uso la subclase BChild  ¿?
    b = new BChild();
    // Uso la sublcase BKinder  ¿?
    b = new BKinder();
  }

  public void task()
  {
    // doSomething
    b.task();
    // doSomethingElse
  }
}
