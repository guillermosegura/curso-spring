package com.axity.springmvc.config;

import org.springframework.stereotype.Component;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

/**
 * @author guillermo.segura@axity.com
 */
@Component
@OpenAPIDefinition(info = @Info(title = "Ejemplos de APIs - POC SpringMVC", 
  contact = @Contact(name = "Guillermo Segura", email = "guillermo.segura@axity.com"), 
    license = @License(name = "GNU"), 
        description = "Prueba de concepto de APIs", 
        version = "1.0.0"))
public class OpenApiConfiguration
{

}
