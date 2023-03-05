package com.workshop.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.workshop.Entity.Application;
import com.workshop.Entity.Role;
import com.workshop.Entity.User;
import com.workshop.dto.userRegistrationDto;
import com.workshop.repository.UserRepo;
@Service
public class Userserviceimpl implements Userservice {
	
	@Autowired
	private BCryptPasswordEncoder passwordencoder;
	
	
       private UserRepo userrepo;
	
	public Userserviceimpl  (UserRepo userrepo) {
		super();
		this.userrepo = userrepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user  = userrepo.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid username or password.");

		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
		
	}

	@Override
	public User save(userRegistrationDto registrationDto) {
		
		String hashpassword = passwordencoder.encode(registrationDto.getPassword());
		User user = new User(registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getEmail(), hashpassword,Arrays.asList(new Role("ROLE USER")));
		return userrepo.save(user);
	}
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles;
	}

	
	

}
