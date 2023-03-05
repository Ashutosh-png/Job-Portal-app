package com.workshop.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.workshop.Entity.Application;
import com.workshop.Entity.User;
import com.workshop.dto.userRegistrationDto;


@Service
public interface ApplicationService {
	

	 
	Application getAppbyId(Long id);
	Application saveApp(Application app);
	Iterable<Application> showAll();
	void deletebyid(Long id);

}
