package com.cognizant.Authenticationservice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Authenticationservice.exception.UserAlreadyExistException;
import com.cognizant.Authenticationservice.model.Users;
import com.cognizant.Authenticationservice.repository.UserRepository;
import com.cognizant.Authenticationservice.security.AppUserDetailsService;
import com.cognizant.Authenticationservice.service.EmailServiceImpl;
import com.cognizant.Authenticationservice.service.UserEmailConfirmationService;
import com.cognizant.Authenticationservice.service.UserService;

@RestController
@RequestMapping("/stock-market-charting/users")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserDetailsService userService;
	@Autowired
	UserService userServices;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
	UserEmailConfirmationService userConfirmationService;
	@Autowired
	EmailServiceImpl emailServiceImpl;

	@PostMapping
	public void signup(@RequestBody @Valid Users user) throws UserAlreadyExistException {
		LOGGER.info("Start");
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		appUserDetailsService.signup(user);
		String token = userConfirmationService.setTokenForConfirmation(user.getUserName());
		emailServiceImpl.send("ctstestmail10@gmail.com", user.getEmail(), "confirm your email",
				"http://localhost:8210/authentication-service/stock-market-charting/users/confirm/" + token);
		LOGGER.info("End");
	}

	@GetMapping("/confirm/{token}")
	public void confirmMail(@PathVariable String token) {
		userConfirmationService.confirmMailAddress(token);
	}

	@PutMapping("/update-user")
	public void updateDetails(@RequestBody Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userServices.updateDetails(user);
	}

	@GetMapping("/get-user/{username}")
	public Users getUser(@PathVariable String username) {
		return userRepository.findByUserName(username);
	}
}
