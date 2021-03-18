package mx.com.axity.petstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.com.axity.petstore.service.BService;
import mx.com.axity.petstore.service.CService;

@Component
public class BServiceImpl implements BService
{
  @Autowired
  private CService cService;

  @Override
  public void doSomething()
  {
    System.out.println( "BService.doSomething 1" );
    cService.doSomething();
    System.out.println( "BService.doSomething 2" );
  }

}
