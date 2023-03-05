package com.workshop.service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.workshop.Entity.Application;
import com.workshop.Entity.Role;
import com.workshop.Entity.User;
import com.workshop.dto.userRegistrationDto;
import com.workshop.repository.Repository;
import com.workshop.repository.UserRepo;

@Service
public class ApplicationServiceimpl implements ApplicationService {
	
	

	
	
	
	private Repository repo;
	
	public ApplicationServiceimpl (Repository repo) {
		super();
		this.repo = repo;
	}
	
	

	@Override
	public Application getAppbyId(Long id) {
		return repo.findById(id).get();
		
	}

	@Override
	public Application saveApp(Application app) {
		// TODO Auto-generated method stub
		return repo.save(app);
	}

	@Override
	public Iterable<Application> showAll() {
		
		return repo.findAll();
	}

	@Override
	public void deletebyid(Long id) {
		 repo.deleteById(id);
		
	}

	
	

}
