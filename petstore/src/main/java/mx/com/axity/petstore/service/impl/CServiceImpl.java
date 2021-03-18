package mx.com.axity.petstore.service.impl;

import org.springframework.stereotype.Component;

import mx.com.axity.petstore.service.CService;

@Component
public class CServiceImpl implements CService
{

  @Override
  public void doSomething()
  {
    System.out.println( "CService.doSomething" );

  }

}
