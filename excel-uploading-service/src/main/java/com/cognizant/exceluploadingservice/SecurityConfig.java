package com.cognizant.exceluploadingservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.cognizant.exceluploadingservice.security.JwtAuthorizationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);


	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		LOGGER.info("Start");
		httpSecurity.cors();
		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests()
		.antMatchers("/stock-market-charting/upload").permitAll()
		.antMatchers("/stock-market-charting/summary").permitAll()
		.anyRequest().authenticated()
		.and().addFilter(new JwtAuthorizationFilter(authenticationManager()));
		LOGGER.info("End");
	}

}