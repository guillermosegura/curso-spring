package mx.com.axity.poc.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import mx.com.axity.poc.config.NameServiceMockedConfig;
import mx.com.axity.poc.to.Stock;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = NameServiceMockedConfig.class)
public class PortfolioServiceTest
{

  @Autowired
  private PortfolioService portfolioService;

  @Autowired
  private StockService stockService;

  @Before
  public void setUp() throws Exception
  {
  }

  @Test
  public void testGetMarketValue()
  {
    // Creates a list of stocks to be added to the portfolio
    List<Stock> stocks = new ArrayList<Stock>();
    Stock googleStock = new Stock( "1", "Google", 10 );
    Stock microsoftStock = new Stock( "2", "Microsoft", 100 );

    stocks.add( googleStock );
    stocks.add( microsoftStock );

    // add stocks to the portfolio
    portfolioService.setStocks( stocks );

    // mock the behavior of stock service to return the value of various stocks
    when( stockService.getPrice( googleStock ) ).thenReturn( 50.00 );
    when( stockService.getPrice( microsoftStock ) ).thenReturn( 1000.00 );

    double marketValue = portfolioService.getMarketValue();

    assertEquals( 100500.0, marketValue, 0.1 );
  }

}
