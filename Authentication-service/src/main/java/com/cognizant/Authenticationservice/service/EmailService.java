package com.cognizant.Authenticationservice.service;

public interface EmailService {
	void send(String from, String to, String title, String body);
}
