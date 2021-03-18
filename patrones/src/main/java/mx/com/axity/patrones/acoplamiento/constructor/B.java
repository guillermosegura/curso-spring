package mx.com.axity.patrones.acoplamiento.constructor;

public class B
{
  private int attr1;
  private int attr2;
  private int attr3;
  private int attr4;

  public B() { }

  public B( int attr1, int attr2, int attr3, int attr4 ) {
    this.attr1 = attr1;
    this.attr2 = attr2;
    this.attr3 = attr3;
    this.attr4 = attr4;
  }

  public void task()
  {
    // perform task
  }
}
