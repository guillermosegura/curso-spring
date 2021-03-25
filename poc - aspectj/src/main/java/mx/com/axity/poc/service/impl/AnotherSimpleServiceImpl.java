package mx.com.axity.poc.service.impl;

import mx.com.axity.poc.aop.Intercept;
import mx.com.axity.poc.service.SimpleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("anotherSimpleService")
public class AnotherSimpleServiceImpl implements SimpleService
{
  private static final Logger LOG = LoggerFactory.getLogger( AnotherSimpleServiceImpl.class );

  @Intercept
  @Override
  public void doSomething()
  {
    LOG.info( "doSomething" );
  }

  @Override
  public void doSomethingElse()
  {
    LOG.info( "doSomethingElse" );
  }

}
