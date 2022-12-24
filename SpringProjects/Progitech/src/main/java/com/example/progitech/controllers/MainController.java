package com.example.progitech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	// Landing Page
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	// Dashboard
	@GetMapping("/shopnow")
	public String shopnow() {
		return "dashboard.jsp";
	}
	
	// Join Event
	@GetMapping("/joinevent")
	public String joinevent() {
		return "joinevent.jsp";
	}
	
	// Show One
	@GetMapping("/products/px-master-3s")
	public String showOne() {
		return "showone.jsp";
	}
	
	// Admin Access
	@GetMapping("/private/admin")
	public String admin() {
		return "admin.jsp";
	}
	
	// Admin Access - Products
	@GetMapping("/private/admin/products")
	public String adminProducts() {
		return "adminproducts.jsp";
	}
	
}
