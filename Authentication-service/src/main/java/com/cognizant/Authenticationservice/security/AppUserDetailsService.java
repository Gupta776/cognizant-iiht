package com.cognizant.Authenticationservice.security;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.Authenticationservice.model.Role;
import com.cognizant.Authenticationservice.model.Users;
import com.cognizant.Authenticationservice.repository.UserRepository;


@Service
public class AppUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository usersRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersRepository.findByUserName(username);
		System.out.println(user);
		UserDetails appUser = null;
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		} else {
			appUser = new AppUser(user);
		}
		return appUser;
	}

	public AppUserDetailsService(UserRepository usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}

	@Transactional
	public void signup(Users user) {
		System.out.println(usersRepository.findByUserName(user.getUserName()));
		if (usersRepository.findByUserName(user.getUserName()) != null) {
		} else {
			Set<Role> role = new HashSet();
			role.add(new Role(1, "user"));
			user.setRoleList(role);
			usersRepository.save(user);
		}
	}

}