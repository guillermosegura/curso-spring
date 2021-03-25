package mx.com.axity.poc;

import mx.com.axity.poc.to.Data;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "mx.com.axity.poc.controller", "mx.com.axity.poc.service", "mx.com.axity.poc.dao" })
public class AppConfig
{

  @Bean
  public Data myData()
  {
    return new Data(1, "Azul", null);
  }
  
  @Bean
  @Qualifier("otraData")
  public Data data()
  {
    return new Data(2, "Verde", null);
  }
}
