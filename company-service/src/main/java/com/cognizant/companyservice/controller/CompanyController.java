package com.cognizant.companyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.cognizant.companyservice.DTO.CompanyDTO;
import com.cognizant.companyservice.model.Company;
import com.cognizant.companyservice.service.CompanyService;


@RestController
@RequestMapping("/stock-market-charting/company")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@GetMapping("/all-companies")
	public List<Company> getAllCompanies(){
		return companyService.findAllCompanies();
	}
//	@GetMapping("/company-details/{companyName}")
//	public CompanyDTO getAllCompanyDetails(@PathVariable String companyName) {
//		return this.companyService.getCompany(companyName);
//	}
	
}