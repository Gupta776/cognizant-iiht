package com.cognizant.Authenticationservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Authenticationservice.exception.UserAlreadyExistException;
import com.cognizant.Authenticationservice.model.Users;
import com.cognizant.Authenticationservice.security.AppUserDetailsService;

@RestController
@RequestMapping("/stock-market-charting/users")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping
	public void signup(@RequestBody @Valid Users user) throws UserAlreadyExistException {
		LOGGER.info("Start");
 		user.setPassword(passwordEncoder.encode(user.getPassword()));
		appUserDetailsService.signup(user);
		LOGGER.info("End");
	}
}
