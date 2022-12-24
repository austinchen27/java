package com.example.beltexam.controllers;

import javax.servlet.http.HttpSession;
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

import com.example.beltexam.models.Baby;
import com.example.beltexam.models.LoginUser;
import com.example.beltexam.models.User;
import com.example.beltexam.services.BabyService;
import com.example.beltexam.services.UserService;

@Controller
public class MainController {
	// import service
	@Autowired
	private UserService userService;
	
	@Autowired
	private BabyService babyService;
	
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
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    		return "redirect:/";
    }
    
    // === DASHBOARD === //
    
    @GetMapping("/home")
    public String dashboard(Model model, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("babyList", babyService.allBabies()); // get all projects
    	model.addAttribute("oneUser", userService.oneUser(session.getAttribute("userId")));
    	model.addAttribute("unassignedUpvotes", babyService.getUnassignedUsers(userService.oneUser((Long) session.getAttribute("userId"))));
    	return "dashboard.jsp";
    }
    
    // Create New Baby Name
    @GetMapping("/names/new")
    public String newName(Model model, HttpSession session) {
    	model.addAttribute("userId", session.getAttribute("userId"));
    	model.addAttribute("userName", session.getAttribute("userName"));
    	if(session.getAttribute("userId") == null) return "redirect:/";
    	model.addAttribute("newBabies", new Baby());
    	return "new.jsp";
    }
    
    // Process New Baby Name
    @PostMapping("/names/new/success")
    public String processBaby(@Valid @ModelAttribute("newBabies") Baby newBaby, BindingResult result, Model model, HttpSession session) {
    	model.addAttribute("userId", session.getAttribute("userId"));
    	model.addAttribute("userName", session.getAttribute("userName"));
    	if(session.getAttribute("userId") == null) return "redirect:/";
    	if(result.hasErrors()) {
    		model.addAttribute("newBabies", newBaby);
    		model.addAttribute("userId", session.getAttribute("userId"));
    		return "new.jsp";
    	} else {
    		babyService.createBaby(newBaby);
    		return "redirect:/home";
    	}
    }
    
    // Show One Baby
    @GetMapping("/names/{id}")
    public String showBaby(@PathVariable("id") Long id, Model model, HttpSession session) {
    	model.addAttribute("userId", session.getAttribute("userId"));
    	model.addAttribute("userName", session.getAttribute("userName"));
    	model.addAttribute("unassignedUpvotes", babyService.getUnassignedUsers(userService.oneUser((Long) session.getAttribute("userId"))));
    	if(session.getAttribute("userId") == null) return "redirect:/";
    	model.addAttribute("oneBaby", babyService.oneBaby(id));
    	return "showone.jsp";
    }
    
    // Edit A Baby
    @GetMapping("/names/{id}/edit")
    public String editBaby(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if(session.getAttribute("userId") == null) return "redirect:/";
    	if(!session.getAttribute("userId").equals(babyService.oneBaby(id).getUser().getId())) {
    		return "redirect:/home";
    	}
    	model.addAttribute("oneBaby", babyService.oneBaby(id));
    	return "edit.jsp";
    }

    // Update a Baby
    @PutMapping("/names/{id}/edit/success")
    public String updateBaby(@Valid @ModelAttribute("oneBaby") Baby baby, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
    	if(!session.getAttribute("userId").equals(babyService.oneBaby(id).getUser().getId())) {
    		return "redirect:/home";
    	}
    	if(result.hasErrors()) {
    		model.addAttribute("oneBaby", baby);
    		return "edit.jsp";
    	}
    	babyService.save(baby);
    	return "redirect:/home";
    }
    
    // Delete One Baby
    @DeleteMapping("/names/delete/{id}")
    public String deleteBaby(@Valid @ModelAttribute("oneBaby") Baby baby, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
    	babyService.deleteBaby(id);
    	return "redirect:/home";
    }

    // === BLACK BELT ===
    // Give an upvote
    @PutMapping("/upvote/join/{id}")
    public String giveUpvote(@PathVariable("id") Long babyId, Model model, HttpSession session) {
    	if(session.getAttribute("userId") == null) return "redirect:/";
    	babyService.upvote(babyId, session.getAttribute("userId"));
    	return "redirect:/home";
    }
    
    @PutMapping("/upvote/leave/{id}")
    public String removeUpvote(@PathVariable("id") Long babyId, Model model, HttpSession session) {
    	if(session.getAttribute("userId") == null) return "redirect:/";
    	userService.downvote(babyId, session.getAttribute("userId"));
    	return "redirect:/home";
    }
    
    
    
    
}














