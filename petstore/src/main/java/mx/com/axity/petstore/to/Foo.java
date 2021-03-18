package mx.com.axity.petstore.to;

public class Foo
{

  private String bar;

  public void doSomething()
  {
    System.out.println( String.format( "Do something... %s", this.bar ) );
  }

  public String getBar()
  {
    return bar;
  }

  public void setBar( String bar )
  {
    this.bar = bar;
  }

  public void init()
  {
    System.out.println( "Foo::init" );
  }
}
