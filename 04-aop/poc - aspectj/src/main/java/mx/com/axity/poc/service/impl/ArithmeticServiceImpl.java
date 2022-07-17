package mx.com.axity.poc.service.impl;

import mx.com.axity.poc.service.ArithmeticService;
import mx.com.axity.poc.to.Operation;

import org.springframework.stereotype.Service;

@Service
public class ArithmeticServiceImpl implements ArithmeticService
{

  @Override
  public Operation add( Operation operation )
  {
    operation.setResult( operation.getA() + operation.getB() );
    return operation;
  }

  @Override
  public Operation substract( Operation operation )
  {
    operation.setResult( operation.getA() - operation.getB() );

    return operation;
  }

  @Override
  public Operation multiply( Operation operation )
  {
    operation.setResult( operation.getA() * operation.getB() );
    return operation;
  }

  @Override
  public Operation divide( Operation operation )
  {
    operation.setResult( operation.getA() / operation.getB() );
    return operation;
  }

}
