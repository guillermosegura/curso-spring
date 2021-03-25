package mx.com.axity.poc.service;

import mx.com.axity.poc.to.Strange;

public interface SimpleService
{
  void doSomething();
  
  void doSomethingElse();
  
  void hello(String str);
  
  void somethingStrange(Strange strange);
}
