package com.example.demo;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

	@Autowired
	private UserRepo repo;

	@GetMapping("/")
	public String welcome() {
		return "index";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute UserDTO dto, Model model) {
		repo.save(dto);
		model.addAttribute("msg", "success");
		return "index";
	}

	int loginAttempts = 0;
	LocalDateTime lockedUntil = null;
	
	@PostMapping("/login")
	public String login(@ModelAttribute UserDTO dto, Model model) {
		System.out.println("lockedUntil------->"+lockedUntil);
		if (lockedUntil!=null && LocalDateTime.now().compareTo(lockedUntil)<0) {
			model.addAttribute("loginMsg", "Account locked. Please try again later.");
			return "index";
		}
		UserDTO getDto = repo.findByUser(dto.getUsername());
		if (getDto==null) {
			model.addAttribute("loginMsg", "No User found.");
			return "index";
		}
		 if (getDto.getPassword().equals(dto.getPassword())) {
             // Successful login
			 model.addAttribute("loginMsg", "login success");
             loginAttempts = 0;
         } else {
             // Unsuccessful login
             loginAttempts++;
             model.addAttribute("loginMsg","Invalid credentials. Attempts left: "+ (3-loginAttempts));

             if (loginAttempts == 3) {
                 // Lock the account for 2 minutes
                 lockedUntil = LocalDateTime.now().plusMinutes(2);
                 model.addAttribute("loginMsg", "Account locked. Please try again later.");
             }
         }
		return "index";
	}
}
