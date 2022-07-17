package mx.com.axity.poc.to;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Operation
{
  public enum Type
  {
    ADD, SUBSTRACT, MULTIPLY, DIVIDE
  };
  private Integer a;
  private Integer b;
  private Integer result;
  private int code;
  private String message;
  private Type type;

  public Integer getA()
  {
    return a;
  }

  public void setA( Integer a )
  {
    this.a = a;
  }

  public Integer getB()
  {
    return b;
  }

  public void setB( Integer b )
  {
    this.b = b;
  }

  public Integer getResult()
  {
    return result;
  }

  public void setResult( Integer result )
  {
    this.result = result;
  }

  public int getCode()
  {
    return code;
  }

  public void setCode( int code )
  {
    this.code = code;
  }

  public String getMessage()
  {
    return message;
  }

  public void setMessage( String message )
  {
    this.message = message;
  }

  public Type getType()
  {
    return type;
  }

  public void setType( Type type )
  {
    this.type = type;
  }

  public String toString()
  {
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    return gson.toJson( this );
  }
}
