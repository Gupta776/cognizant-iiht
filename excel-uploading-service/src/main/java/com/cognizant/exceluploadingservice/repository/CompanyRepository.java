package com.cognizant.exceluploadingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.exceluploadingservice.model.Company;




public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	@Query(value="select cp_id,cp_code,cp_name,cp_turnover,cp_ceo,cp_listed,\r\n" + 
			"cp_se_id,cp_brief from company where cp_code=?1 ",nativeQuery=true)
	public Company findByCompanyCode(Long companyCode);
	
}
