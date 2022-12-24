package com.example.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dojosandninjas.models.Dojo;
import com.example.dojosandninjas.models.Ninja;
import com.example.dojosandninjas.services.DojoService;
import com.example.dojosandninjas.services.NinjaService;

@Controller
public class MainController {
	
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	// Display Dojo form
	@GetMapping("/dojos/new")
	public String newDojoForm(Model model) {
		model.addAttribute("newDojo", new Dojo());
		model.addAttribute("dojoList", dojoService.allDojos());
		return "dojoCreate.jsp";
	}
	
	// Process dojo form
	@PostMapping("/dojos/new")
	public String processUserForm(
			@Valid @ModelAttribute("newDojo") Dojo newDojo,
			BindingResult result) {
		if(result.hasErrors()) {
			return "dojoCreate.jsp";
		} else {
			dojoService.createDojo(newDojo);
			return "redirect:/dojos/new";
		}
	}
	
	// Create a Ninja
	@GetMapping("/ninjas")
	public String displayNinja(Model model) {
		model.addAttribute("newNinja", new Ninja());
		model.addAttribute("dojoList", dojoService.allDojos());
		return "ninjaCreate.jsp";
	}
	
	// Process a Ninja
	@PostMapping("/ninjas")
	public String createNinja(
			@Valid @ModelAttribute("newNinja") Ninja newNinja,
			BindingResult result) {
		if(result.hasErrors()) {
			return "ninjaCreate.jsp";
		} else {
			Ninja ninja = ninjaService.createNinja(newNinja);
			Long id = ninja.getId();
			return "redirect:/dojos/" + id;
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String showOneDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("oneDojo", dojoService.oneDojo(id));
		model.addAttribute("ninjaList", ninjaService.allNinjas());
		return "dojoShow.jsp";
	}

}
