package com.example.projectmanager.controllers;

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

import com.example.projectmanager.models.LoginUser;
import com.example.projectmanager.models.Project;
import com.example.projectmanager.models.Task;
import com.example.projectmanager.models.User;
import com.example.projectmanager.services.ProjectService;
import com.example.projectmanager.services.TaskService;
import com.example.projectmanager.services.UserService;

@Controller
public class MainController {
	// import service
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TaskService taskService;
	
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
    
        return "redirect:/projects"; //home
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
        return "redirect:/projects"; //home
    }
    
    // === PROJECT MANAGER === 
    
    // Project Dash board
    @GetMapping("/projects")
    public String dashboard(Model model, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("projectList", projectService.allProjects()); // get all projects
    	model.addAttribute("oneUser", userService.oneUser(session.getAttribute("userId")));
    	model.addAttribute("unassignedProjects", projectService.getUnassignedUsers(userService.oneUser((Long) session.getAttribute("userId"))));
    	return "dashboard.jsp";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    		return "redirect:/";
    }
    
    // Project Create New Project
    @GetMapping("/projects/new")
    public String newProject(Model model, HttpSession session) {
    	model.addAttribute("userId", session.getAttribute("userId"));
    	model.addAttribute("userName", session.getAttribute("userName"));
    	if(session.getAttribute("userId") == null) return "redirect:/";
    	model.addAttribute("newProjects", new Project());
    	return "new.jsp";
    	}
    
    // Process New Project
    @PostMapping("/projects/new/success")
    public String processProject(@Valid @ModelAttribute("newProjects") Project newProject, BindingResult result, Model model, HttpSession session) {
    	model.addAttribute("userId", session.getAttribute("userId"));
    	model.addAttribute("userName", session.getAttribute("userName"));
    	if(session.getAttribute("userId") == null) return "redirect:/";
    	if(result.hasErrors()) {
    		model.addAttribute("newProjects", newProject);
    		model.addAttribute("userId", session.getAttribute("userId"));
    		return "new.jsp";
    	} else {
    		projectService.createProject(newProject);
    		return "redirect:/projects";
    	}
    }
    
    // Show One Project
    @GetMapping("/projects/show/{id}")
    public String showProject(@PathVariable("id") Long id, Model model, HttpSession session) {
    	model.addAttribute("userId", session.getAttribute("userId"));
    	model.addAttribute("userName", session.getAttribute("userName"));
    	if(session.getAttribute("userId") == null) return "redirect:/";
    	model.addAttribute("oneProject", projectService.oneProject(id));
    	return "showone.jsp";
    }
    
    // Edit a Project
    @GetMapping("/projects/edit/{id}")
    public String editProject(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if(!session.getAttribute("userId").equals(projectService.oneProject(id).getUser().getId())) {
    	return "redirect:/";
    	}
    	model.addAttribute("oneProject", projectService.oneProject(id));
    	return "edit.jsp";
	}
    
    // Update a Project
    @PutMapping("/projects/edit/{id}/success")
    public String updateProject(@Valid @ModelAttribute("oneProject") Project project, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
    	if(!session.getAttribute("userId").equals(projectService.oneProject(id).getUser().getId())) {
    		return "redirect:/project";
    	}
    	if(result.hasErrors()) {
    		model.addAttribute("oneProject", project);
    		return "edit.jsp";
    	}
    	projectService.save(project);
    	return "redirect:/projects/show/{id}";
    }
    
    // Delete One Project
    @DeleteMapping("projects/delete/{id}")
    public String deleteProject(@Valid @ModelAttribute("oneProject") Project project, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
    	if(!session.getAttribute("userId").equals(projectService.oneProject(id).getUser().getId())){
    		return "redirect:/projects";
    	}
    	// delete tasks for the project
    	projectService.deleteBook(id);
    	return "redirect:/projects";
    }
    
    // === BLACK BELT ===
    // Joining a team
    @PutMapping("/team/join/{id}")
    public String joinTeam(@PathVariable("id") Long projectId, Model model, HttpSession session) {
    	if(session.getAttribute("userId") == null) return "redirect:/";
    	projectService.joinTeam(projectId, session.getAttribute("userId"));
    	return "redirect:/projects";
    }
    
    
    // Leave a team
    @PutMapping("/team/leave/{id}")
    public String leaveTeam(@PathVariable("id") Long projectId, Model model, HttpSession session) {
    	if(session.getAttribute("userId") == null) return "redirect:/";
    	userService.leaveTeam(projectId, session.getAttribute("userId"));
    	return "redirect:/projects";
    }
    
    // === TASKS ===
    @GetMapping("/projects/{id}/tasks")
    public String seeTasks(@PathVariable("id") Long projectId, Model model, HttpSession session) {
    	if(session.getAttribute("userId") == null) return "redirect:/";
    	model.addAttribute("oneProject", projectService.oneProject(projectId));
    	model.addAttribute("task", new Task());
    	return "task.jsp";
    }
    
    @PostMapping("/projects/{projectId}/tasks/success")
    public String createTask(@Valid @ModelAttribute("task") Task task, BindingResult result, @PathVariable("projectId") Long projectId, HttpSession session, Model model) {
    	if(session.getAttribute("userId") == null) return "redirect:/";
    	if(result.hasErrors()) {
    		model.addAttribute("oneProject", projectService.oneProject(projectId));
    		model.addAttribute("task", task);
    		return "task.jsp";
    	}
    	taskService.createTask(task, projectId, session.getAttribute("userId"));
    		return "redirect:/projects/{projectId}/tasks";
    }
    
}





// For loop to check tasks
//Project project = projectService.oneProject(projectId);
//for(int i=0; i<project.getTasks().size();i++) {
//	System.out.println(project.getTasks().get(i));


