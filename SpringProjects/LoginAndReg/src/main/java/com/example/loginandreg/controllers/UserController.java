package com.example.loginandreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.loginandreg.models.LoginUser;
import com.example.loginandreg.models.User;
import com.example.loginandreg.services.UserService;

@Controller
public class UserController {
	// import service
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String logregform(Model model, HttpSession session) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "logreg.jsp";
	}
	
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
    	User registeredUser = userService.register(newUser, result);
        // to do some extra validations and create a new user!
    	
        // 1. get the registeredUser by calling register in service and make use of the binding result

        // 2. check for result errors
        // 2.1 if there are errors, put the missing model in and return jsp
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "logreg.jsp"; // error return back to logreg
        }
        // 2.2 if no errors, set userId in session and redirect
        session.setAttribute("userId", registeredUser.getId());
        session.setAttribute("userName", registeredUser.getUserName());
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
    
        return "redirect:/home"; //home
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
    	
        // 1. get the user by calling login in service and make use of the binding result
    	User loginUser = userService.login(newLogin, result);
       // 2. check for result errors
       // 2.1 if there are errors, put the missing model in and return jsp
       // 2.2 if no errors, get the user info from user and set userId in the session
        
        // Add once service is implemented:
        // User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "logreg.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("userId", loginUser.getId());
        session.setAttribute("userName", loginUser.getUserName());
        return "redirect:/home"; //home
    }
    
    @GetMapping("/donations")
    public String dashboard(Model model, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	return "dashboard.jsp";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    		return "redirect:/";
    }
    
}
