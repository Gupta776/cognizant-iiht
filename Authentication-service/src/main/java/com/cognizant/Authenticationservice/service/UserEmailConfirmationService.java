package com.cognizant.Authenticationservice.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Authenticationservice.model.UserEmailConfirmation;
import com.cognizant.Authenticationservice.model.Users;
import com.cognizant.Authenticationservice.repository.UserEmailConfirmationRepository;
import com.cognizant.Authenticationservice.repository.UserRepository;


@Service
public class UserEmailConfirmationService {

	@Autowired
	UserEmailConfirmationRepository confirmationRepository;
	@Autowired
	UserRepository userRepository;
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	@Transactional
	public String setTokenForConfirmation(String userId) {
		String token=randomAlphaNumeric();
		UserEmailConfirmation userConfirmation = new UserEmailConfirmation(1, token, userId);
		confirmationRepository.save(userConfirmation);
		return token;
	}
	@Transactional
	public void confirmMailAddress(String token) {
		UserEmailConfirmation userConfirmation=confirmationRepository.findByToken(token);
		if(userConfirmation!=null) {
			confirmationRepository.delete(userConfirmation);
			Users user = userRepository.findByUserName(userConfirmation.getUserId());
			user.setConfirmed(true);
			userRepository.save(user);
		}
	}
	public static String randomAlphaNumeric() {

		int count = 10;
		StringBuilder builder = new StringBuilder();

		while (count-- != 0) {

			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());

			builder.append(ALPHA_NUMERIC_STRING.charAt(character));

		}

		return builder.toString();

	}
}
