package com.cognizant.Authenticationservice.exception;

public class UserAlreadyExistException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistException() {
		super("User alredy exist");
	}
}
