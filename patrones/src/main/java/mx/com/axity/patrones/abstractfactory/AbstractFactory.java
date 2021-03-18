package mx.com.axity.patrones.abstractfactory;

import mx.com.axity.patrones.abstractfactory.message.Type;
import mx.com.axity.patrones.abstractfactory.service.Service;

public interface AbstractFactory
{
  Service create( Type type );
}
