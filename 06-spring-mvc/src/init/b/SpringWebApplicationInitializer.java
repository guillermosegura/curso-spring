package com.axity.springmvc.config;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.axity.springmvc.aop.LoggingFilter;

/**
 * Inicializa el contexto de Spring y registra el servlet
 * 
 * @author guillermo.segura@axity.com
 */
public class SpringWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
  /**
   * {@inheritDoc}
   */
  @Override
  protected Class<?>[] getRootConfigClasses()
  {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Class<?>[] getServletConfigClasses()
  {
    return new Class<?>[] { WebConfig.class };
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected String[] getServletMappings()
  {
    return new String[] { "/" };
  }

  @Override
  protected Filter[] getServletFilters()
  {
    return new Filter[] { new LoggingFilter() };
  }
}