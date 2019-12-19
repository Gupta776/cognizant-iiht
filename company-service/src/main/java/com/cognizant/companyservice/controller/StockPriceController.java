package com.cognizant.companyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.companyservice.model.StockPrice;
import com.cognizant.companyservice.service.StockPriceService;

@RestController
@RequestMapping("/stock-market-charting")
public class StockPriceController {

	@Autowired
	StockPriceService stockPriceService;
	@GetMapping("/stock-price")
	public List<StockPrice> getAllStockList() {
		return stockPriceService.getAllStockPrice();
	}
	
	@GetMapping("/stock-price/latest/{companyCode}")
	public List<StockPrice> getLatest(@PathVariable long companyCode) {
		return stockPriceService.getLatestStock(companyCode);
	}
	@GetMapping("/stock-price/{companyCode}")
	public List<StockPrice> getStockByCompanyCode(@PathVariable long companyCode) {
		return stockPriceService.getStockByCompanyCode(companyCode);
	}
	
}