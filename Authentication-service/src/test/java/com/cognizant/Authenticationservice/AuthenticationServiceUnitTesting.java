package com.cognizant.Authenticationservice;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cognizant.Authenticationservice.exception.UserAlreadyExistException;
import com.cognizant.Authenticationservice.model.Role;
import com.cognizant.Authenticationservice.model.Users;
import com.cognizant.Authenticationservice.repository.UserRepository;
import com.cognizant.Authenticationservice.security.AppUserDetailsService;

//@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AuthenticationServiceUnitTesting {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceUnitTesting.class);
 	UserRepository repository = Mockito.mock(UserRepository.class);
 	AppUserDetailsService service = new AppUserDetailsService(repository);
 
 	@Test
 	public void mockTestLoadUserByUsername() {
 		LOGGER.info("Start");
 		when(repository.findByUserName("admin")).thenReturn(createUser());
 		UserDetails user = service.loadUserByUsername("admin");
 		String expected = "$2a$10$IoqonpxYeSWir9ir16Pb6.8sCa444mtsH6R6oH.ioWnHkpODsBsPS";
 		assertEquals(expected, user.getPassword());
 		LOGGER.info("End");
 	}
 	private Users createUser()  {
 		Set<Role> role = new HashSet<Role>();
 		role.add(new Role(1,"admin"));
 		Users user = new Users(1,"admin","$2a$10$IoqonpxYeSWir9ir16Pb6.8sCa444mtsH6R6oH.ioWnHkpODsBsPS","admin@gmail.com","1234356788",true,role);
 		return user;
 	}
 	@Test(expected = UsernameNotFoundException.class)
 	public void testLoadByUserNameNotFoundException() throws UsernameNotFoundException {
 		when(repository.findByUserName("rohith")).thenReturn(null);
 		service.loadUserByUsername("rohith");
 	}
// 	@Test(expected = UserAlreadyExistException.class)
// 	public void testForUserExist() throws UserAlreadyExistException {
// 		LOGGER.info("Start");
// 		Set<Role> role = new HashSet<Role>();
// 		role.add(new Role(1,"admin"));
// 		Users user = new Users(1,"admin","$2a$10$IoqonpxYeSWir9ir16Pb6.8sCa444mtsH6R6oH.ioWnHkpODsBsPS","admin@gmail.com","1234356788",true,role);
// 		when(repository.findByUserName("admin")).thenReturn(user);
// 		service.signup(user);
// 		LOGGER.info("End");
// 	}
 	@Test
 	public void newSignUp() throws UserAlreadyExistException {
 		LOGGER.info("Start");
 		when(repository.findByUserName("rohith")).thenReturn(null);
 		Users user = new Users(1,"rohith","$2a$10$IoqonpxYeSWir9ir16Pb6.8sCa444mtsH6R6oH.ioWnHkpODsBsPS","rohithnarjala@gmail.com","7356490987",true);
 		service.signup(user);
 		LOGGER.info("End");
 
 	}
}
