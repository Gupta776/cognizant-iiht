package com.cognizant.companyservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.companyservice.model.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	Users findByUserName(String userName);

}
