package mx.com.axity.poc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.axity.poc.aop.Intercept;
import mx.com.axity.poc.service.SimpleService;
import mx.com.axity.poc.to.Strange;

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

  @Override
  public void hello( String str )
  {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void somethingStrange( Strange strange )
  {
    // TODO Auto-generated method stub
    
  }

}
