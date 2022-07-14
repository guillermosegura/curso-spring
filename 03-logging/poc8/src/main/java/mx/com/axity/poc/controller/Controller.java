package mx.com.axity.poc.controller;

import javax.annotation.PostConstruct;

import mx.com.axity.poc.Main;
import mx.com.axity.poc.service.Service;
import mx.com.axity.poc.to.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class Controller
{

  private static final Logger LOG = LoggerFactory.getLogger( Controller.class );

  @Autowired
  private Service service;

  @Autowired(required = false)
  @Qualifier("myData")
  private Data data1;

  @Autowired(required = false)
  @Qualifier("otraData")
  private Data data2;

  @PostConstruct
  public void init()
  {
    LOG.error( "Ocurrió un error de negocio y/o comunicaciones" );
    LOG.warn( "Mensaje de advertencia" );
    LOG.info( "Mensaje informativo, provee data necesaria para análisis posterior" );
    LOG.debug( "Mensaje a nivel debug, datos para diagnosticar" );
    LOG.trace( "Menor nivel de bitacoreo (Paso 1...n)" );
  }

  public void save( Data data )
  {
    service.save( data );
  }

}
