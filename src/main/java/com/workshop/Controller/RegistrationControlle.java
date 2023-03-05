package com.workshop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.dto.userRegistrationDto;
import com.workshop.service.ApplicationService;
import com.workshop.service.Userservice;

@Controller

public class RegistrationControlle {
	
	private Userservice service;
	
	
	public RegistrationControlle (Userservice service) {
		super();
		this.service = service;
	}
	
	
	@ModelAttribute("user")
	public userRegistrationDto userregistrationDto () {
		return new userRegistrationDto();
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/")
	public String home() {
		return "redirect:/home";
	}
	@GetMapping("/registration")
	public String showRegistrationForm( ) {
		return "registration";
	}
	
	@PostMapping("/registration")
	public String registeruser(@ModelAttribute("user") userRegistrationDto userregistrationDto ) {
		service.save(userregistrationDto);
		 return "redirect:/registration?success";

	}

	

}
