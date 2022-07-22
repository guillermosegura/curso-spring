package com.axity.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.axity.springmvc.aop.LoggingInterceptor;
import com.axity.springmvc.aop.TracingInterceptor;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * Configuración de las vistas
 * 
 * @author guillermo.segura@axity.com
 */
@Configuration
@ComponentScan({ "com.axity.springmvc.config", 
    "com.axity.springmvc.controller", 
    "com.axity.springmvc.services",
    "com.axity.springmvc.dao", 
    "com.axity.springmvc.aop" })
@EnableWebMvc
@EnableTransactionManagement
@EnableAspectJAutoProxy
@Import({org.springdoc.core.SpringDocConfiguration.class,
  org.springdoc.webmvc.core.SpringDocWebMvcConfiguration.class,
  org.springdoc.webmvc.ui.SwaggerConfig.class,
  org.springdoc.core.SwaggerUiConfigProperties.class,
  org.springdoc.core.SwaggerUiOAuthProperties.class,
  org.springdoc.core.SpringDocConfigProperties.class,
  org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration.class})
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
  public void addInterceptors( InterceptorRegistry registry )
  {
    registry.addInterceptor( new LoggingInterceptor() );
    registry.addInterceptor( new TracingInterceptor() );
  }

}
