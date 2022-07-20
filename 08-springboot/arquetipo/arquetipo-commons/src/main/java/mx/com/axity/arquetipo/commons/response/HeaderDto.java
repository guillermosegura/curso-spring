package mx.com.axity.arquetipo.commons.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase DTO de encabezado
 * 
 * @author guillermo.segura@axity.com
 */
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class HeaderDto
{
  private int code;
  private String message;
  private String trace;

  /**
   * Constructor default
   */
  public HeaderDto()
  {
    this.code = 0;
    this.message = "OK";
  }

  /**
   * Constructor por código y mensaje
   * 
   * @param code
   * @param message
   */
  public HeaderDto( int code, String message )
  {
    this.code = code;
    this.message = message;
  }

  /**
   * Constructor por código, mensaje y traza
   * 
   * @param code
   * @param message
   * @param trace
   */
  public HeaderDto( int code, String message, String trace )
  {
    this.code = code;
    this.message = message;
    this.trace = trace;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public String toString()
  {
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    return gson.toJson( this );
  }
}
