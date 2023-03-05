package com.workshop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.Entity.Application;
import com.workshop.service.ApplicationServiceimpl;
@Controller
@RequestMapping("/home")
public class MainController {
	
	private ApplicationServiceimpl service;
	
	
	public MainController (ApplicationServiceimpl service) {
		super();
		this.service= service;
	}
	
	
	@GetMapping
	public String showHome(Model model) {
		Iterable<Application> app=service.showAll();
		model.addAttribute("app", app);
		return "home";
	}
	
	
	@GetMapping("/postpage")
	public String showPostpage() {
		return "postPage";
	}
	
	@GetMapping("/up/{id}")
	public String showupdate(@PathVariable Long id,Model model) {
		model.addAttribute("app",service.getAppbyId(id));
		return "update";
	}
	
	@PostMapping("/postpage/post")
	public String postApp(@ModelAttribute Application app) {
		service.saveApp(app);
		
		return "redirect:/home/postpage";
	}
	
	
	@RequestMapping("/{id}")
	public String deleteapp(@PathVariable Long id) {
		service.deletebyid(id);
		return "redirect:/home/";
	}
	
	
	@RequestMapping("/update/{id}")
	public String updateapp(@PathVariable Long id, @ModelAttribute("body") Application app, Model model) {
		Application info = service.getAppbyId(id);
		info.setName(app.getName());
		info.setAddress(app.getAddress());
		info.setPosition(app.getPosition());
		service.saveApp(info);
		return "redirect:/home/";
		
		
	}

	
	
}
