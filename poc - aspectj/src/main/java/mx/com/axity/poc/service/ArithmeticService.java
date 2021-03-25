package mx.com.axity.poc.service;

import mx.com.axity.poc.to.Operation;

public interface ArithmeticService
{

  Operation add( Operation operation );

  Operation substract( Operation operation );

  Operation multiply( Operation operation );

  Operation divide( Operation operation );

}
