package mx.com.axity.arquetipo.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.slf4j.Slf4j;
import mx.com.axity.arquetipo.controller.dto.QueryWrapperDto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * @author guillermo.segura@axity.com
 */
@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
//@GraphQlTest
class EmployeeGraphQLControllerIntegration
{

  @Autowired
  private MockMvc mockMvc;

  /**
   * Test method for
   * {@link mx.com.axity.arquetipo.controller.EmployeeGraphQLController#getAllEmployees(java.lang.String, java.lang.String, java.lang.String, graphql.schema.DataFetchingEnvironment)}.
   */
  @Test
  void testGetAllEmployees() throws Exception
  {
    String query = "query {\r\n"//
        + "    employees (lastName : \"Patterson\") {\r\n"//
        + "        employeeNumber\r\n"//
        + "        lastName\r\n"//
        + "        firstName\r\n"//
        + "        email\r\n"//
        + "        office {\r\n"//
        + "            officeCode\r\n"//
        + "            city\r\n"//
        + "            state\r\n"//
        + "            country\r\n"//
        + "            addressLine1\r\n"//
        + "            addressLine2\r\n"//
        + "        }\r\n"//
        + "    }\r\n"//
        + "}";
    
    
    Gson gson = new GsonBuilder().create();
    
    var wrapper = new QueryWrapperDto();
    wrapper.setQuery( query );

    MvcResult result = mockMvc
        .perform( MockMvcRequestBuilders.post( "/graphql" )
          .content( gson.toJson( wrapper ) )
          .accept( MediaType.APPLICATION_JSON )
          .contentType( MediaType.APPLICATION_JSON ) )
        .andExpect( status().isOk() )
        .andExpect(request().asyncStarted())
        .andReturn();
    
    this.mockMvc.perform( asyncDispatch( result ) )
    .andDo( print() ).andExpect(status().isOk())
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect( jsonPath( "$.data" ).isNotEmpty() )
    .andExpect( jsonPath( "$.data.employees" ).isArray() )
    .andReturn();

    assertNotNull( result );
    
    var content = result.getResponse().getContentAsString();
    log.info( "--->{}", content );
  }

  /**
   * Test method for
   * {@link mx.com.axity.arquetipo.controller.EmployeeGraphQLController#getEmployeeById(java.lang.Long, graphql.schema.DataFetchingEnvironment)}.
   */
  @Test
  void testGetEmployeeById() throws Exception
  {
    String query = "query {\r\n"
        + "    employee (employeeNumber:1056) {\r\n"
        + "        lastName\r\n"
        + "        firstName\r\n"
        + "        office {\r\n"
        + "            officeCode\r\n"
        + "            city\r\n"
        + "            state\r\n"
        + "            country\r\n"
        + "        }\r\n"
        + "    }\r\n"
        + "}";
    
    
    Gson gson = new GsonBuilder().create();
    
    var wrapper = new QueryWrapperDto();
    wrapper.setQuery( query );

    MvcResult result = mockMvc
        .perform( MockMvcRequestBuilders.post( "/graphql" )
          .content( gson.toJson( wrapper ) )
          .accept( MediaType.APPLICATION_JSON )
          .contentType( MediaType.APPLICATION_JSON ) )
        .andExpect( status().isOk() )
        .andExpect(request().asyncStarted())
        .andReturn();
    
    this.mockMvc.perform( asyncDispatch( result ) )
    .andDo( print() ).andExpect(status().isOk())
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect( jsonPath( "$.data" ).isNotEmpty() )
    .andExpect( jsonPath( "$.data.employee" ).isNotEmpty())
    .andExpect( jsonPath( "$.data.employee.lastName" ).value( "Patterson" ))
    .andReturn();

    assertNotNull( result );
    
    var content = result.getResponse().getContentAsString();
    log.info( "--->{}", content );
  }

  /**
   * Test method for
   * {@link mx.com.axity.arquetipo.controller.EmployeeGraphQLController#getAllEmployeesByExample(mx.com.axity.arquetipo.commons.response.graphql.EmployeeGraphQLDto, graphql.schema.DataFetchingEnvironment)}.
   */
  @Test
  void testGetAllEmployeesByExample() throws Exception
  {
    String query = "query {\r\n"
        + "    employeesByExample(query : {\r\n"
        + "        office : { \r\n"
        + "            country: \"USA\"\r\n"
        + "        }\r\n"
        + "    }) {\r\n"
        + "        lastName\r\n"
        + "        firstName\r\n"
        + "        email\r\n"
        + "        extension\r\n"
        + "        reportsTo {\r\n"
        + "            employeeNumber\r\n"
        + "            firstName\r\n"
        + "            lastName\r\n"
        + "            email\r\n"
        + "        }\r\n"
        + "        office {\r\n"
        + "            officeCode\r\n"
        + "            phone\r\n"
        + "            city\r\n"
        + "            state\r\n"
        + "            country\r\n"
        + "            territory\r\n"
        + "        }\r\n"
        + "        customers\r\n"
        + "            {\r\n"
        + "                customerName\r\n"
        + "                city\r\n"
        + "                contactLastName\r\n"
        + "                contactFirstName\r\n"
        + "            }\r\n"
        + "    }\r\n"
        + "}";
    
    
    Gson gson = new GsonBuilder().create();
    
    var wrapper = new QueryWrapperDto();
    wrapper.setQuery( query );

    MvcResult result = mockMvc
        .perform( MockMvcRequestBuilders.post( "/graphql" )
          .content( gson.toJson( wrapper ) )
          .accept( MediaType.APPLICATION_JSON )
          .contentType( MediaType.APPLICATION_JSON ) )
        .andExpect( status().isOk() )
        .andExpect(request().asyncStarted())
        .andReturn();
    
    this.mockMvc.perform( asyncDispatch( result ) )
    .andDo( print() ).andExpect(status().isOk())
    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    .andExpect( jsonPath( "$.data" ).isNotEmpty() )
    .andExpect( jsonPath( "$.data.employeesByExample" ).isArray() )
    .andReturn();

    assertNotNull( result );
    
    var content = result.getResponse().getContentAsString();
    log.info( "--->{}", content );
  }
  
  

}
