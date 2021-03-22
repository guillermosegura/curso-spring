package mx.com.axity.poc.controller;

import javax.annotation.PostConstruct;

import mx.com.axity.poc.service.Service;
import mx.com.axity.poc.to.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Controller
{
  @Autowired
  private Service service;

  @Autowired
  @Qualifier("myData")
  private Data data1;

  @Autowired
  @Qualifier("otraData")
  private Data data2;

  @Autowired
  @Qualifier("data2")
  private Data data2b;

  public Controller()
  {
    System.out.println( "Construye Controller" );
  }

  public Controller( Service service )
  {
    System.out.println( "Construye Controller con service" );
    this.service = service;
  }

  @PostConstruct
  public void inicio()
  {
    System.out.println( "Inicializado" );
    System.out.println( "Data1:" + data1 );
    System.out.println( "Data2:" + data2 );
    System.out.println( "Data2b:" + data2b );
  }

  public void save( Data data )
  {
    service.save( data );
  }

}
