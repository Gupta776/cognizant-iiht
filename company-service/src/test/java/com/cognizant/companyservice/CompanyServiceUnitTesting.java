package com.cognizant.companyservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cognizant.companyservice.Repository.CompanyRepository;
import com.cognizant.companyservice.Repository.StockPriceRepository;
import com.cognizant.companyservice.model.BoardOfDirectors;
import com.cognizant.companyservice.model.Company;
import com.cognizant.companyservice.model.Sector;
import com.cognizant.companyservice.model.StockExchange;
import com.cognizant.companyservice.model.StockPrice;
import com.cognizant.companyservice.service.CompanyServiceImpl;
import com.cognizant.companyservice.service.StockPriceServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CompanyServiceUnitTesting {
	CompanyRepository companyRepository = Mockito.mock(CompanyRepository.class);
	CompanyServiceImpl companyService = new CompanyServiceImpl(companyRepository);

//	StockExchangeRepository stockExchangeRepository = Mockito.mock(StockExchangeRepository.class);
//	StockExchangeService stockExchangeService = new StockExchangeService(stockExchangeRepository);
	
	StockPriceRepository stockPriceRepository = Mockito.mock(StockPriceRepository.class);
	StockPriceServiceImpl stockPriceService = new StockPriceServiceImpl(stockPriceRepository);
	
	public Company createCompany() {
		BoardOfDirectors boardOfDirectors = new BoardOfDirectors(1,"mackinson",1); 
		List<BoardOfDirectors> listOfDirectors = new ArrayList<BoardOfDirectors>();
		listOfDirectors.add(boardOfDirectors);
		StockExchange stockExchange = new StockExchange(1,"BSE","Bombay","nill","nill");
		List<StockExchange> stockExchangeList = new ArrayList<StockExchange>();
		stockExchangeList.add(stockExchange);
		Sector sector = new Sector(1,"Banking","bank");
		Company company = new Company(1,500112L,"BOI",54123L,"guru",listOfDirectors,true,sector,"nil", stockExchangeList);
		return company;
		}
	
	public List<Company> createCompanyList(){
		List<Company> companyList = new ArrayList<Company>();
		companyList.add(createCompany());
		return companyList;
	}
	
	public StockPrice createStockPrice() {
		StockPrice stockPrice = new StockPrice(1, 500112L, "BSE", 345L, new Date(), new Time(0));
		return stockPrice;
	}
	
	public List<StockPrice> createStockPriceList(){
		List<StockPrice> stockPrices = new ArrayList<StockPrice>();
		stockPrices.add(createStockPrice());
		return stockPrices;
	}
	
	@Test
	public void mockGetAllCompanies() {
		when(companyRepository.findAll()).thenReturn(createCompanyList());
		List<Company> companyList = companyService.findAllCompanies();
		assertEquals(companyList.get(0).getCeo(), createCompanyList().get(0).getCeo());
	}
	@Test
	public void mockGetAllStockPrices() {
		when(stockPriceRepository.findAll()).thenReturn(createStockPriceList());
		List<StockPrice> stockPrices = stockPriceService.getAllStockPrice();
		assertEquals(stockPrices.get(0).getCurrentPrice(), createStockPriceList().get(0).getCurrentPrice());
	}
	
//	@Test
//	public void testGetAllStockExchange() {
//		when(stockExchangeRepository.findAll()).thenReturn(createCompany().getStockExchangeList());
//		List<StockExchange> stockExchanges = stockExchangeService.getAllStockExchange();
//		assertEquals(stockExchanges.get(0).getAddress(), createCompany().getStockExchangeList().get(0).getAddress());
//	}
//	
	@Test
	public void testGetStockByCompanyCode() {
		when(stockPriceRepository.getAllStockPrices(500112L)).thenReturn(createStockPriceList());
		List<StockPrice> stockPrices = stockPriceService.getStockByCompanyCode(500112L);
		assertEquals(stockPrices.get(0).getCurrentPrice(), createStockPriceList().get(0).getCurrentPrice());
	}
	
	@Test
	public void testGetLatestStock() {
		when(stockPriceRepository.getStockPrice(500112L)).thenReturn(createStockPriceList());
		List<StockPrice> stockPrices = stockPriceService.getLatestStock(500112L);
		assertEquals(stockPrices.get(0).getCurrentPrice(), createStockPriceList().get(0).getCurrentPrice());
	}
	
}
