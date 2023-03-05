package com.workshop.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.workshop.Entity.User;
import com.workshop.dto.userRegistrationDto;



public interface Userservice extends UserDetailsService{
	User save(userRegistrationDto registrationDto);


}
