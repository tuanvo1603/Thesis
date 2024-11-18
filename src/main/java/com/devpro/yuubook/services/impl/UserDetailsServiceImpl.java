package com.devpro.yuubook.services.impl;

import com.devpro.yuubook.models.entities.User;
import com.devpro.yuubook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService { 

	@Autowired 
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.getUserByEmail(email);
		if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
		return user;// trả về implementation của userDetails
	} 

}
