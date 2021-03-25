package mx.com.axity.poc.controller;

import mx.com.axity.poc.service.ArithmeticService;
import mx.com.axity.poc.to.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArithmeticController
{

  @Autowired
  private ArithmeticService arithmeticService;

  public Operation execute( Operation operation )
  {

    if( operation.getType().equals( Operation.Type.ADD ) )
    {
      operation = arithmeticService.add( operation );
    }
    else if( operation.getType().equals( Operation.Type.SUBSTRACT ) )
    {
      operation = arithmeticService.substract( operation );
    }
    else if( operation.getType().equals( Operation.Type.MULTIPLY ) )
    {
      operation = arithmeticService.multiply( operation );
    }
    else if( operation.getType().equals( Operation.Type.DIVIDE ) )
    {
      operation = arithmeticService.divide( operation );
    }

    return operation;
  }

  public void setArithmeticService( ArithmeticService arithmeticService )
  {
    this.arithmeticService = arithmeticService;
  }

}
