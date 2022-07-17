package mx.com.axity.poc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import mx.com.axity.poc.aop.Intercept;
import mx.com.axity.poc.service.SimpleService;

@Intercept
@Service("simpleService")
public class SimpleServiceImpl implements SimpleService
{
  private static final Logger LOG = LoggerFactory.getLogger( SimpleServiceImpl.class );


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
