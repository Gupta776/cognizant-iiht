package com.cognizant.companyservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Service;

//import com.cognizant.companyservice.DTO.CompanyDTO;
import com.cognizant.companyservice.Repository.CompanyRepository;
import com.cognizant.companyservice.model.Company;

@Service
@EnableEurekaClient
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyRepository companyRepository;
	
	
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}


	@Override
	public List<Company> findAllCompanies() {
		// TODO Auto-generated method stub
//		return companyRepository.findAll();
//		CompanyDTO companyDTO = new CompanyDTO();
//		companyDTO.setCompanyList(companyRepository.findAll());
		return companyRepository.findAll();
	}
	
}
