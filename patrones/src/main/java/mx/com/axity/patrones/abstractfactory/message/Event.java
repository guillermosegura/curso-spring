package mx.com.axity.patrones.abstractfactory.message;

public class Event
{
  private Type type;
  private Message message;

  public Type getType()
  {
    return type;
  }

  public void setType( Type type )
  {
    this.type = type;
  }

  public Message getMessage()
  {
    return message;
  }

  public void setMessage( Message message )
  {
    this.message = message;
  }

}
