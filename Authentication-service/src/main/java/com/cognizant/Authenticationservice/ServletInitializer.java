package com.cognizant.Authenticationservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServletInitializer.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		LOGGER.info("start");
		LOGGER.info("end");
		return application.sources(AuthenticationServiceApplication.class);
	}

}
