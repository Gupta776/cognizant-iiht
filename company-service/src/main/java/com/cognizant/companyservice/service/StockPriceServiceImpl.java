package com.cognizant.companyservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.companyservice.Repository.StockPriceRepository;
import com.cognizant.companyservice.model.StockPrice;


@Service
public class StockPriceServiceImpl implements StockPriceService{

	@Autowired
	StockPriceRepository stockPriceRepository;
	
	public StockPriceServiceImpl(StockPriceRepository stockPriceRepository) {
		super();
		this.stockPriceRepository = stockPriceRepository;
	}
	@Transactional
	public List<StockPrice> getAllStockPrice() {
		return stockPriceRepository.findAll();
	}
	@Transactional
	public List<StockPrice> getLatestStock(long companyCode){
		return stockPriceRepository.getStockPrice(companyCode);
	}
	@Override
	public List<StockPrice> getStockByCompanyCode(long companyCode) {
		// TODO Auto-generated method stub
		return stockPriceRepository.getAllStockPrices(companyCode);
	}
	
}