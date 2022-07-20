package mx.com.axity.example.controller;

import java.io.Serializable;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.axity.example.to.Hello;

/**
 * @author guillermo.segura@axity.com
 */
@RestController
@RequestMapping("/api")
public class HelloWorldController
{
  @GetMapping(path = "/hello")
  public String hello()
  {
    return "Hello world!";
  }

  @GetMapping(path = "/helloJson", produces = MediaType.APPLICATION_JSON_VALUE)
  public Hello helloJson()
  {
    return new Hello( "Hello world!" );
  }

  @GetMapping(path = "/helloXml", produces = MediaType.APPLICATION_XML_VALUE)
  public Hello helloXml()
  {
    return new Hello( "Hello world!" );
  }

  @GetMapping(path = "/hi")
  public ResponseEntity<Serializable> sayHi( @RequestParam(name = "type", required = false, defaultValue = "json")
  String type )
  {
    var headers = new HttpHeaders();
    Serializable body;
    switch( type )
    {
      case "json":
        body = new Hello( "Hello world!" );
        headers.add( HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE );
        break;
      case "xml":
        body = new Hello( "Hello world!" );
        headers.add( HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE );
        break;
      case "text":
        body = "Hello world!";
        headers.add( HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE );
        break;
      case "html":
        body = "<html><head><title>Hi!!!</title></head><body><h2>Hello world!</h2></body></html>";
        headers.add( HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML_VALUE );
        break;
      default:
        body = "Hello world!";
        headers.add( HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE );
        break;
    }
    
    return new ResponseEntity<>( body, headers, HttpStatus.OK );
  }
}
