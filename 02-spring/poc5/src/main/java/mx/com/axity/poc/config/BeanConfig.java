package mx.com.axity.poc.config;

import mx.com.axity.poc.to.Data;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig
{
  @Bean
  public Data myData()
  {
    return new Data( 1, "Azul", null );
  }

  @Bean(name = "otraData", initMethod = "init")
  @Qualifier("otraData")
  public Data data()
  {
    return new Data( 2, "Verde", null );
  }
}
