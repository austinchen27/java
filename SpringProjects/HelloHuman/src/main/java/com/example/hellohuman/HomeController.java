package com.example.hellohuman;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String index(
			@RequestParam(value="name", required=false) String firstNameInMethod ,
			@RequestParam(value="last_name", required=false) String lastNameInMethod
			) {
		if(firstNameInMethod != null && lastNameInMethod != null) {
			return "Hello " + firstNameInMethod + " " + lastNameInMethod;
		} else if (firstNameInMethod != null) {
			return "Hello " + firstNameInMethod;
		} else if (lastNameInMethod != null) {
			return "Hello " + "Dr. " + lastNameInMethod;
		} else {
			return "Hello Human";
		}
}

	}
