package com.axity.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.axity.springmvc.aop.LoggingInterceptor;
import com.axity.springmvc.aop.TracingInterceptor;

/**
 * Configuración de las vistas
 * 
 * @author guillermo.segura@axity.com
 */
@Configuration
@ComponentScan({ "com.axity.springmvc.config", "com.axity.springmvc.controller", "com.axity.springmvc.services",
    "com.axity.springmvc.dao", "com.axity.springmvc.aop" })
@EnableWebMvc
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class WebConfig implements WebMvcConfigurer
{

  @Bean
  public InternalResourceViewResolver getInternalResourceViewResolver()
  {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix( "/WEB-INF/view/" );
    resolver.setSuffix( ".jsp" );
    return resolver;

  }

  @Override
  public void addResourceHandlers( ResourceHandlerRegistry registry )
  {
    registry.addResourceHandler( "/resources/**" ).addResourceLocations( "/resources/" );
  }
  
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(new LoggingInterceptor());
      registry.addInterceptor( new TracingInterceptor() );
  }

}
