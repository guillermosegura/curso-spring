package com.axity.springmvc.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author guillermo.segura@axity.com
 */
public class LoggingInterceptor implements HandlerInterceptor
{
  private Logger logger = LoggerFactory.getLogger( LoggingInterceptor.class );

  @Override
  public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception
  {
    logger.info( "preHandle" );
    return true;
  }

  @Override
  public void postHandle( HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView ) throws Exception
  {
    logger.info( "postHandle" );
  }

  @Override
  public void afterCompletion( HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex )
      throws Exception
  {
    logger.info( "afterCompletion" );
  }
}
