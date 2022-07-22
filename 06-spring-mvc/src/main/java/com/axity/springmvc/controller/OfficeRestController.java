package com.axity.springmvc.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axity.springmvc.aop.JsonResponseIntercept;
import com.axity.springmvc.exception.Module;
import com.axity.springmvc.services.OfficeService;
import com.axity.springmvc.to.Office;
import com.axity.springmvc.to.PaginatedResponse;
import com.axity.springmvc.to.openapi.OfficeResponse;
import com.axity.springmvc.util.Validator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Controlador base de oficinas
 * 
 * @author guillermo.segura@axity.com
 */
@RestController
@RequestMapping("/api/offices")
@CrossOrigin(origins = "*")
public class OfficeRestController
{

  @Autowired
  private OfficeService officeService; 

  /**
   * Atiende la petición Rest de consulta de oficinas
   * 
   * @return
   */
  @Operation(tags = "Offices", description = "Consulta las oficinas", summary = "Consulta las oficinas")
  @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
  @JsonResponseIntercept(Module.OFFICE)
  public ResponseEntity<Serializable> getOffices( @RequestParam(required = false, defaultValue = "0") int page,
      @RequestParam(required = false, defaultValue = "20") int pageSize )
  {
    PaginatedResponse<Office> offices = officeService.findAllPaginated( page, pageSize );
    return new ResponseEntity<>( offices, HttpStatus.OK );
  }

  @Operation(tags = "Offices", description = "Consulta la oficina por el officeCode", summary = "Consulta la oficina por el officeCode")
  @ApiResponses(value= {
      @ApiResponse(responseCode = "200", description = "Oficina encontrada",
          content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
            schema = @Schema(implementation = OfficeResponse.class))})
  })
  @GetMapping(path = "/{officeCode}", produces = MediaType.APPLICATION_JSON_VALUE)
  @JsonResponseIntercept(Module.OFFICE)
  public ResponseEntity<Serializable> findOfficeById( @PathVariable("officeCode") String officeCode )
  {
    Office office = this.officeService.get( officeCode );
    ResponseEntity<Serializable> response;
    if( office != null )
    {
      response = new ResponseEntity<>( office, HttpStatus.OK );
    }
    else
    {
      response = new ResponseEntity<>( HttpStatus.NO_CONTENT );
    }
    return response;
  }

  /**
   * Crea un registro de oficinas
   * 
   * @param office
   * @return
   */
  @Operation(tags = "Offices", description = "Crea una oficina", summary = "Crea una oficina")
  @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @JsonResponseIntercept(Module.OFFICE)
  public ResponseEntity<Serializable> create( @RequestBody Office office )
  {
    office.setOfficeCode( Validator.adjustLength( office.getOfficeCode(), 10 ) );
    office.setCity( Validator.adjustLength( office.getCity(), 50 ) );
    office.setPhone( Validator.adjustLength( office.getPhone(), 50 ) );
    office.setAddressLine1( Validator.adjustLength( office.getAddressLine1(), 50 ) );
    office.setAddressLine2( Validator.adjustLength( office.getAddressLine2(), 50 ) );
    office.setState( Validator.adjustLength( office.getState(), 50 ) );
    office.setCountry( Validator.adjustLength( office.getCountry(), 50 ) );
    office.setPostalCode( Validator.adjustLength( office.getPostalCode(), 15 ) );
    office.setTerritory( Validator.adjustLength( office.getTerritory(), 10 ) );
    this.officeService.create( office );

    return new ResponseEntity<>( office, HttpStatus.CREATED );
  }

  /**
   * Edita un registro de oficinas
   * 
   * @param office
   * @param officeCode
   * @return
   */
  @Operation(tags = "Offices", description = "Edita una oficina", summary = "Edita una oficina")
  @PutMapping(value = "/{officeCode}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @JsonResponseIntercept(Module.OFFICE)
  public ResponseEntity<Serializable> edit( @RequestBody Office office, @PathVariable("officeCode") String officeCode )
  {
    office.setOfficeCode( Validator.adjustLength( officeCode, 10 ) );
    office.setCity( Validator.adjustLength( office.getCity(), 50 ) );
    office.setPhone( Validator.adjustLength( office.getPhone(), 50 ) );
    office.setAddressLine1( Validator.adjustLength( office.getAddressLine1(), 50 ) );
    office.setAddressLine2( Validator.adjustLength( office.getAddressLine2(), 50 ) );
    office.setState( Validator.adjustLength( office.getState(), 50 ) );
    office.setCountry( Validator.adjustLength( office.getCountry(), 50 ) );
    office.setPostalCode( Validator.adjustLength( office.getPostalCode(), 15 ) );
    office.setTerritory( Validator.adjustLength( office.getTerritory(), 10 ) );
    this.officeService.edit( office );

    return new ResponseEntity<>( office, HttpStatus.OK );
  }

  /**
   * Elimina un registro de oficinas
   * 
   * @param officeCode
   * @return
   */
  @Operation(tags = "Offices", description = "Elimina una oficina", summary = "Elimina una oficina")
  @DeleteMapping(value = "/{officeCode}", produces = MediaType.APPLICATION_JSON_VALUE)
  @JsonResponseIntercept(Module.OFFICE)
  public ResponseEntity<Serializable> delete( @PathVariable("officeCode") String officeCode )
  {
    this.officeService.delete( officeCode );
    return new ResponseEntity<>( HttpStatus.OK );
  }
}
