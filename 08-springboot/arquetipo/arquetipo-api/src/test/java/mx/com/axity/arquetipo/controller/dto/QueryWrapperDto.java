package mx.com.axity.arquetipo.controller.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author guillermo.segura@axity.com
 */
@Getter
@Setter
public class QueryWrapperDto
{
  private String query;
  private Object variables = new Object();
}
