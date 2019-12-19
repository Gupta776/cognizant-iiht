package com.cognizant.companyservice.service;

import java.util.List;

import com.cognizant.companyservice.model.StockPrice;

public interface StockPriceService {
	public List<StockPrice> getAllStockPrice();
	public List<StockPrice> getLatestStock(long companyCode);
	public List<StockPrice> getStockByCompanyCode(long companyCode);
}
