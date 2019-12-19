package com.cognizant.Authenticationservice;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.Authenticationservice.model.Role;
import com.cognizant.Authenticationservice.model.Users;
import com.cognizant.Authenticationservice.security.AppUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class AuthenticationServiceApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	AppUserDetailsService appUserDetailsService;
	@Autowired
	private MockMvc mockMvc;

	
	@Test
	public void addUser() throws Exception {

		Set<Role> role = new HashSet<Role>();
		role.add(new Role(2, "USER"));
		
		mockMvc.perform(MockMvcRequestBuilders.post("/stock-market-charting/users")
				.content(asJsonString(new Users(45, "users", "abcd", "ssss@sss.com", "1234567890",true, role)))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
				
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
