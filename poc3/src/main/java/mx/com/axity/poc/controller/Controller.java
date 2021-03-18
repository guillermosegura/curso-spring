package mx.com.axity.poc.controller;

import org.springframework.stereotype.Component;

import mx.com.axity.poc.service.Service;
import mx.com.axity.poc.to.Data;


@Component
public class Controller
{

  private Service service;

  public Controller()
  {
  }

  public Controller( Service service )
  {
    this.service = service;
  }

  public void save( Data data )
  {
    service.save( data );
  }

  public void setService( Service service )
  {
    this.service = service;
  }

}
