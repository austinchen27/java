package com.example.bookclub.controllers;

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

import com.example.bookclub.models.Book;
import com.example.bookclub.models.LoginUser;
import com.example.bookclub.models.User;
import com.example.bookclub.services.BookService;
import com.example.bookclub.services.UserService;

@Controller
public class UserController {

	// import service
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String logregform(Model model) {
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
    
        return "redirect:/books"; //home
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
        return "redirect:/books"; //home
    }
    
    @GetMapping("/books")
    public String dashboard(Model model, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("bookList", bookService.allBooks());
    	return "dashboard.jsp";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    		return "redirect:/";
    }
    
    //    === Books ===	//
    @GetMapping("/books/new")
    public String createBook(Model model, Long id, HttpSession session) {
    	model.addAttribute("userId", session.getAttribute("userId"));
    	model.addAttribute("newBooks", new Book());
    	return "newBook.jsp";
    }
    
    // Process Books form
    @PostMapping("/books/new")
    public String processBook(@Valid @ModelAttribute("newBooks") Book newBook, Model model,
    		BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		model.addAttribute("userId", session.getAttribute("userId"));
    		model.addAttribute("newBooks", new Book());
    		return "newBook.jsp";
    	} else {
    		bookService.createBook(newBook);
    		return "redirect:/books";
    	}
    	
    }
    
    // Go to the Book Market
    @GetMapping("/bookmarket")
    public String bookbroker(Model model, HttpSession session) {
    	model.addAttribute("userName", session.getAttribute("userName"));
    	model.addAttribute("userId", session.getAttribute("userId"));
    	if (session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("oneUser", userService.oneUser((Long)session.getAttribute("userId"))); // get one user
    	model.addAttribute("bookList", bookService.allBooks()); // get all books
    	return "bookmarket.jsp";
    }
    
    // Adding a borrowed book
    @PutMapping("/borrow/add/{id}") // Need to use Post mapping?
    public String borrow(@PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	bookService.addBorrower(bookService.oneBook(id), userService.oneUser(session.getAttribute("userId")));
    	return "redirect:/bookmarket";
    }
    
    // Deleting(returning) a borrowed book // Need to use Delete Mapping
    @PutMapping("/borrow/delete/{id}")
    public String delBorrow(@PathVariable("id") Long id, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	bookService.delBorrower(bookService.oneBook(id), userService.oneUser(session.getAttribute("userId")));
    	return "redirect:/bookmarket";
    }
    
    // Edit Book
    @GetMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
    	Book book = bookService.oneBook(id);
    	model.addAttribute("oneBook", book);
    	return "edit.jsp";
    }
    
    // Update Book
    @PutMapping("/books/edit/success/{id}")
    public String editBook(@Valid @ModelAttribute("oneBook") Book book, @PathVariable("id") Long id, Model model, HttpSession session, BindingResult result) {
    	if(!session.getAttribute("userId").equals(bookService.oneBook(id).getUser().getId())) {
    		return "redirect:/";
    	}
    	if(result.hasErrors()) {
        	model.addAttribute("oneBook", book);
        	return "edit.jsp";
    	}
    	bookService.createBook(book);
    	return "redirect:/bookmarket";
    }
    
    // Delete a Book
    @DeleteMapping("books/delete/{id}") // Delete Book
    public String deleteBook(@PathVariable("id") Long id, HttpSession session) {
    	if(!session.getAttribute("userId").equals(bookService.oneBook(id).getUser().getId())) {
    		return "redirect:/bookmarket";
    	}
    	bookService.deleteBook(id);
    	return "redirect:/bookmarket";
    }
    
	
}





