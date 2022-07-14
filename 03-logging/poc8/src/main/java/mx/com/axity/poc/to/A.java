package mx.com.axity.poc.to;

public class A
{
  private B b;

  public A()
  {
    b = new B();
  }

  public void task()
  {
    // doSomething
    b.task();
    // doSomethingElse
  }
}
