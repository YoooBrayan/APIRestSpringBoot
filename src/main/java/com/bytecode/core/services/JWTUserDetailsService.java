package com.bytecode.core.services;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JWTUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		if ("yooo@gmail.com".equals(email)) {
			return new User("yooo@gmail.com", "$2a$10$K2Kdvx5jun0pQjygwBbTIuXbSdH77aa9naFtUQQ7YGhGHvwQJeMXS",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with email: " + email);
		}
	}
}