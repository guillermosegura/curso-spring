package mx.com.axity.poc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TrackOperation
{
  private static final Logger LOG = LoggerFactory.getLogger( TrackOperation.class );

  public Object interceptAdvice( ProceedingJoinPoint pjp ) throws Throwable
  {
    Object result = null;
    LOG.trace( "-> {}", pjp.toLongString() );
    result = pjp.proceed();
    LOG.trace( "<- {}", pjp.toLongString() );
    return result;
  }
}
