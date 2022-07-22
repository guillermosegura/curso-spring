package com.axity.springmvc.to.openapi;

import com.axity.springmvc.to.GenericResponse;
import com.axity.springmvc.to.Office;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author guillermo.segura@axity.com
 */
public class OfficeResponse extends GenericResponse
{
  private static final long serialVersionUID = -1710556457519463778L;
  
  @Schema(required = true, description = "Cuerpo de la petición")
  private Office body;

  /**
   * @return the body
   */
  public Office getBody()
  {
    return body;
  }

  /**
   * @param body the body to set
   */
  public void setBody( Office body )
  {
    this.body = body;
  }

}
