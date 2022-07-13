package mx.com.axity.poc.service;

import java.util.List;

import mx.com.axity.poc.to.Stock;

public interface PortfolioService
{
  double getMarketValue();

  List<Stock> getStocks();

  void setStocks( List<Stock> stocks );

  void setStockService( StockService stockService );
}
