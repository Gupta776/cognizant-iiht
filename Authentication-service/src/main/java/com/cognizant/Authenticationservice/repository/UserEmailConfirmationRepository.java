package com.cognizant.Authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.Authenticationservice.model.UserEmailConfirmation;

@Repository
public interface UserEmailConfirmationRepository extends JpaRepository<UserEmailConfirmation, String> {

	public UserEmailConfirmation findByToken(String token);
	
	@Query(value="insert into confirmation_table values(default,:token,:userId);",nativeQuery = true)
	public void saveDetails(@Param("token") String token, @Param("userId") String userId);
}