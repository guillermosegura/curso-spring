package com.axity.springmvc.to;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(Include.NON_NULL)
public class Header implements Serializable
{

  private static final long serialVersionUID = 4483038131814542859L;
  
  @Schema(required = true, description = "Código de status")
  private String status;
  
  @Schema(required = true, description = "Mensaje de respuesta")
  private String message;
  public String getStatus()
  {
    return status;
  }

  public void setStatus( String status )
  {
    this.status = status;
  }

  public String getMessage()
  {
    return message;
  }

  public void setMessage( String message )
  {
    this.message = message;
  }

}
