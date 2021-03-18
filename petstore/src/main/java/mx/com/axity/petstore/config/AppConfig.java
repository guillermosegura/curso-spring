package mx.com.axity.petstore.config;

import mx.com.axity.petstore.to.Foo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{

  @Bean(initMethod = "init")
  public Foo foo()
  {
    return new Foo();
  }
}
