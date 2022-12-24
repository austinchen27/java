package com.example.onetomany.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.onetomany.models.Donation;
import com.example.onetomany.models.User;
import com.example.onetomany.services.DonationService;
import com.example.onetomany.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private DonationService donationService;
	
	@Autowired
	private UserService userService;
	
	// Create user
	// Display user form
	@GetMapping("/users/new")
	public String newUserForm(Model model) {
		model.addAttribute("newUser", new User());
		return "createUserForm.jsp";
	}
	
	// Process user form
	@PostMapping("/users/new")
	public String processUserForm(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result) {
		if(result.hasErrors()) {
			return "createUserForm.jsp";
		} else {
			userService.createUser(newUser);
			return "redirect:/";
		}
		}
		
	// Create Donations
	// Display form
	@GetMapping("/donations/new")
	public String newDonationForm(@ModelAttribute("newDonation") Donation newDonation, Model model
			) {
		// Render the list of user so that we can pick up user from the list
		List<User> userList = userService.allUsers();
		model.addAttribute("userList", userList);
		
		return "createDonationForm.jsp";
	}
	
	// Process form
	@PostMapping("/donations/new")
	public String processDonationForm(@Valid @ModelAttribute("newDonation") Donation newDonation,
			BindingResult result) {
		if(result.hasErrors()) {
	 		return "createDonationForm.jsp";
		} else {
			donationService.createDonation(newDonation);
			return "redirect:/";
		}
	}
	
	// Dashboard for Donations
	@GetMapping("/")
	public String donationDashboard(Model model) {
		model.addAttribute("userList", userService.allUsers());
		model.addAttribute("donationList", donationService.allDonations());
		return "donationDashboard.jsp";
	}
	
	// Find One User (localhost:8080/users/3)
	@GetMapping("/users/{id}")
	public String oneUser(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.oneUser(id));
		return "userDetail.jsp";
	}
	
	// Find One Donation
	@GetMapping("/donations/{id}")
	public String oneDonation(@PathVariable("id") Long id, Model model) {
		model.addAttribute("donation", donationService.oneDonation(id));
		return "donationDetail.jsp";
	}
	
	// Edit = findOne + create: 1. Find the donation by ID ,, 2. create Form ,, 3. Process
	@GetMapping("/donations/edit/{id}")
	public String editDonationForm(@PathVariable("id") Long id, Model model) {
		List<User> userList = userService.allUsers();
		model.addAttribute("userList", userList);
		model.addAttribute("donation", donationService.oneDonation(id));
		return "editDonation.jsp";
	}
	
	// Process
	@PutMapping("/donations/edit/{id}")
	public String processEditDonation(
			@Valid @ModelAttribute("donation") Donation donation, BindingResult result,
			@PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "editDonation.jsp";
		} else {
			donationService.editDonation(donation);
			return "redirect:/donations/{id}";
		}
	}
	
	// Delete
	@DeleteMapping("/donations/delete/{id}")
	public String processDelete(@PathVariable("id") Long id, Model model) {
		donationService.deleteDonation(id);
		return "redirect:/";
	}
	
	
	
	
}
