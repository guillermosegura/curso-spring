package mx.com.axity.patrones.abstractfactory.service;

import mx.com.axity.patrones.abstractfactory.message.Event;
import mx.com.axity.patrones.abstractfactory.message.Response;

public interface Service
{
  void init();

  Response execute( Event event );
}
