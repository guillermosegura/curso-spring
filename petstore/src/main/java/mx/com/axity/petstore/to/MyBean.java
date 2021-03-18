package mx.com.axity.petstore.to;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;

public class MyBean
{
  private int id;

  @PreDestroy
  @Bean(destroyMethod="destroy")
  public void destroy()
  {
    // doSomething
  }
}
