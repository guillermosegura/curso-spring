package mx.com.axity.arquetipo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.axity.arquetipo.commons.aspectj.JsonResponseInterceptor;
import mx.com.axity.arquetipo.commons.dto.OfficeDto;
import mx.com.axity.arquetipo.commons.request.PaginatedRequestDto;
import mx.com.axity.arquetipo.commons.response.PaginatedResponseDto;
import mx.com.axity.arquetipo.facade.OfficeFacade;

/**
 * @author guillermo.segura@axity.com
 */
@RestController
@RequestMapping("/api/offices")
@JsonResponseInterceptor
@CrossOrigin
public class OfficeController
{
  @Autowired
  private OfficeFacade officeFacade;

  /***
   * COnsulta las oficinas
   * 
   * @param limit
   * @param offset
   * @return
   */
  @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PaginatedResponseDto<OfficeDto>> findOffices(
      @RequestParam(name = "limit", defaultValue = "50", required = false)
      int limit, @RequestParam(name = "offset", defaultValue = "0", required = false)
      int offset )
  {
    var result = this.officeFacade.findOffices( new PaginatedRequestDto( limit, offset ) );
    return ResponseEntity.ok( result );
  }
}
