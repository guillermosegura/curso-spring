package com.axity.springmvc.to;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(Include.NON_NULL)
public class GenericResponse implements Serializable
{

  private static final long serialVersionUID = 2129066540908564159L;

  @Schema(required = true, description = "Encabezado de la petición")
  private Header header;
  private Serializable body;
  public Header getHeader()
  {
    return header;
  }

  public void setHeader( Header header )
  {
    this.header = header;
  }

  public Object getBody()
  {
    return body;
  }

  public void setBody( Serializable body )
  {
    this.body = body;
  }

}
