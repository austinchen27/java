package com.example.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/show")
	public String show() {
		return "show.jsp";
	}
	
	@PostMapping("/show/submit")
	public String data(
			@RequestParam("years") int years,
			@RequestParam("city") String city,
			@RequestParam("person") String person,
			@RequestParam("job") String job,
			@RequestParam("charm") String charm,
			@RequestParam("wish") String wish,
			HttpSession session
			) {
		session.setAttribute("years", years);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("job", job);
		session.setAttribute("charm", charm);
		session.setAttribute("wish", wish);
		return "redirect:/omikuji/show";
	}
}
