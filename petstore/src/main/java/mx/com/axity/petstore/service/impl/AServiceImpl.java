package mx.com.axity.petstore.service.impl;

import mx.com.axity.petstore.service.AService;
import mx.com.axity.petstore.service.BService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AServiceImpl implements AService
{

  @Autowired
  private BService bService;

  @Override
  public void doSomething()
  {
    System.out.println( "AService.doSomething 1" );
    bService.doSomething();
    System.out.println( "AService.doSomething 2" );
  }

}
