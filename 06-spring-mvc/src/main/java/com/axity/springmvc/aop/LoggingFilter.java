package com.axity.springmvc.aop;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author guillermo.segura@axity.com
 */
@WebFilter
public class LoggingFilter implements Filter
{

  private Logger logger = LoggerFactory.getLogger( LoggingFilter.class );

  @Override
  public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain )
      throws IOException, ServletException
  {
    logger.info( "LoggingFilter...");
    var params = request.getParameterNames();
    while( params.hasMoreElements() )
    {
      String param = params.nextElement();
      logger.info( "Param: " + param);
    }
    chain.doFilter( request, response );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void init( FilterConfig filterConfig ) throws ServletException
  {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void destroy()
  {
  }

}
