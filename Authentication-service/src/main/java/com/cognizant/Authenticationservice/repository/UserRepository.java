package com.cognizant.Authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.Authenticationservice.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	Users findByUserName(String userName);

}
