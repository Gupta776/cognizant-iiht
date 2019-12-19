package com.cognizant.companyservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.companyservice.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}