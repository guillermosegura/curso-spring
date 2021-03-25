package mx.com.axity.poc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.axity.poc.aop.Intercept;
import mx.com.axity.poc.service.SimpleService;
import mx.com.axity.poc.to.Strange;

@Intercept
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

  @Override
  public void hello( String str )
  {
    LOG.info( "Hello {} !!", str );

  }

  @Override
  public void somethingStrange( Strange strange )
  {
    LOG.info( "somethingStrange {} ", strange.getId() );

  }

}
