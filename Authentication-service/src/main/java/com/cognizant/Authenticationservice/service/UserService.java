package com.cognizant.Authenticationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Authenticationservice.model.Users;
import com.cognizant.Authenticationservice.repository.UserRepository;


@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	public Users getByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	public void updateDetails(Users user) {
		Users newUser = userRepository.findByUserName(user.getUserName());
		newUser.setContactNumber(user.getContactNumber());
		newUser.setPassword(user.getPassword());
		userRepository.save(newUser);
		
	}
}
