package mx.com.axity.poc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.axity.poc.aop.Intercept;
import mx.com.axity.poc.service.PortfolioService;
import mx.com.axity.poc.service.StockService;
import mx.com.axity.poc.to.Stock;

@Intercept
@Service
public class PortfolioServiceImpl implements PortfolioService
{
  @Autowired
  private StockService stockService;

  private List<Stock> stocks;

  @Override
  public double getMarketValue()
  {
    double marketValue = 0.0;

    for( Stock stock : stocks )
    {
      marketValue += stockService.getPrice( stock ) * stock.getQuantity();
    }
    return marketValue;
  }

  public List<Stock> getStocks()
  {
    return stocks;
  }

  public void setStocks( List<Stock> stocks )
  {
    this.stocks = stocks;
  }

  public void setStockService( StockService stockService )
  {
    this.stockService = stockService;
  }

}
