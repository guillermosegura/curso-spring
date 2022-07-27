package mx.com.axity.arquetipo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.lang.reflect.Type;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;
import mx.com.axity.arquetipo.commons.dto.CustomerDto;
import mx.com.axity.arquetipo.commons.response.GenericResponseDto;
import mx.com.axity.arquetipo.commons.response.PaginatedResponseDto;

/**
 * @author guillermo.segura@axity.com
 */
@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CustomerControllerIntegration
{
  @Autowired
  private MockMvc mockMvc;

  /**
   * Test method for {@link mx.com.axity.arquetipo.controller.CustomerController#findCustomers(int, int)}.
   */
  @SuppressWarnings("unchecked")
  @Test
  void testFindCustomers() throws Exception
  {
    MvcResult result = mockMvc.perform( MockMvcRequestBuilders.get( "/api/customers?limit=20&offset=0" ) )
        .andExpect( status().isOk() ) //
        .andExpect( jsonPath( "$.header.code" ).value( "0" ) ) //
        .andExpect( jsonPath( "$.page" ).value( "0" ) ) //
        .andExpect( jsonPath( "$.size" ).value( "20" ) ) //
        .andExpect( jsonPath( "$.data" ).isArray() ) //
        .andExpect( jsonPath( "$.data[0].customerNumber" ).value( "237" ) ) //
        .andReturn();

    assertNotNull( result );

    var content = result.getResponse().getContentAsString();
    log.info( content );

    Gson gson = new GsonBuilder().create();
    Type genericType = new TypeToken<PaginatedResponseDto<CustomerDto>>()
    {
    }.getType();

    var response = (PaginatedResponseDto<CustomerDto>) gson.fromJson( content, genericType );
    assertEquals( 0, response.getHeader().getCode() );
    assertEquals( 0, response.getPage() );
    assertEquals( 20, response.getSize() );
    assertEquals( 237L, response.getData().stream().findFirst().orElse( null ).getCustomerNumber() );

    assertNotNull( response );
  }

  /**
   * Test method for {@link mx.com.axity.arquetipo.controller.CustomerController#findCustomer(java.lang.Long)}.
   */
  @SuppressWarnings("unchecked")
  @Test
  void testFindCustomer() throws Exception
  {
    MvcResult result = mockMvc.perform( MockMvcRequestBuilders.get( "/api/customers/237" ) )
        .andExpect( status().isOk() ) //
        .andExpect( jsonPath( "$.header.code" ).value( "0" ) ) //
        .andExpect( jsonPath( "$.body" ).isNotEmpty() ) //
        .andExpect( jsonPath( "$.body.customerNumber" ).value( "237" ) ) //
        .andReturn();
    assertNotNull( result );

    var content = result.getResponse().getContentAsString();
    log.info( content );

    Gson gson = new GsonBuilder().create();
    Type genericType = new TypeToken<GenericResponseDto<CustomerDto>>()
    {
    }.getType();

    var response = (GenericResponseDto<CustomerDto>) gson.fromJson( content, genericType );
    assertEquals( 0, response.getHeader().getCode() );
    assertEquals( 237L, response.getBody().getCustomerNumber() );

    assertNotNull( response );
  }

  /**
   * Test method for
   * {@link mx.com.axity.arquetipo.controller.CustomerController#create(mx.com.axity.arquetipo.commons.dto.CustomerDto)}.
   */
  @Test
  void testCreate() throws Exception
  {
    CustomerDto customer = new CustomerDto();
    customer.setCustomerName( "CustomerName" );
    customer.setContactFirstName( "ContactFirstName" );
    customer.setContactLastName( "ContactLastName" );
    customer.setCity( "City" );
    customer.setAddressLine1( "AddressLine1" );
    customer.setAddressLine2( "AddressLine2" );
    customer.setCountry( "Country" );
    customer.setCreditLimit( new BigDecimal( "100000" ) );
    customer.setPhone( "+52 55 5555 5555" );
    customer.setPostalCode( "55555" );
    customer.setState( "State" );

    Gson gson = new GsonBuilder().create();

    MvcResult result = mockMvc
        .perform( MockMvcRequestBuilders.post( "/api/customers" ).content( gson.toJson( customer ) ) //
            .accept( MediaType.APPLICATION_JSON ) //
            .contentType( MediaType.APPLICATION_JSON ) ) //
        .andExpect( status().isCreated() ) //
        .andExpect( jsonPath( "$.header.code" ).value( "0" ) ) //
        .andExpect( jsonPath( "$.body" ).isNotEmpty() ) //
        .andReturn();

    assertNotNull( result );

    var content = result.getResponse().getContentAsString();
    log.info( content );
  }

}
