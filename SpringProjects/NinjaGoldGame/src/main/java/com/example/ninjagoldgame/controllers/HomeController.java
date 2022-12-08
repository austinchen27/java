package com.example.ninjagoldgame.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("/Gold")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/Gold")
	public String gold(
			@RequestParam(value="farm", required=false) String farm,
			@RequestParam(value="cave", required = false) String cave,
			@RequestParam(value="house", required = false) String house,
			@RequestParam(value="quest", required = false) String quest,
			HttpSession session,
			RedirectAttributes redirectAttributes
			) {
		SimpleDateFormat format = new SimpleDateFormat("MM d Y h:mm a");
		ArrayList<String> actions = new ArrayList<String>();
}
