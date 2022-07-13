package mx.com.axity.poc.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import mx.com.axity.poc.service.PortfolioService;
import mx.com.axity.poc.service.StockService;
import mx.com.axity.poc.service.impl.PortfolioServiceImpl;

@Configuration
public class NameServiceMockedConfig
{

  @Bean
  @Primary
  public StockService stockService()
  {
    return Mockito.mock( StockService.class );
  }

  @Bean
  public PortfolioService portfolioService()
  {
    return new PortfolioServiceImpl();
  }
}
