package com.axity.springmvc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Aspect
@Component
public class TracingInterceptor implements HandlerInterceptor
{
  private static final Logger LOG = LoggerFactory.getLogger( TracingInterceptor.class );

  @Around("execution (* com.axity.springmvc..*.*(..))")
  public Object interceptMethodAdvice( ProceedingJoinPoint pjp ) throws Throwable
  {
    Object result = null;
    try
    {
      
      LOG.trace( String.format( "--> %s", pjp.getSignature().toLongString()) );
      result = pjp.proceed();
      LOG.trace( String.format( "<-- %s", pjp.getSignature().toLongString() ) );
    }
    catch( Exception e )
    {
      LOG.error( e.getMessage(), e );
      throw e;
    }
    return result;
  }

}
