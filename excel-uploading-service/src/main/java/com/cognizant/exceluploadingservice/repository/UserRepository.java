package com.cognizant.exceluploadingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.exceluploadingservice.model.Users;



@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	public Users findByUserName(String username);
}