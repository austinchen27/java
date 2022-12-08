package com.example.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mvc.models.Book;
import com.example.mvc.services.BookService;

@Controller
public class HomeController {
	
	@Autowired
	BookService bookService;
	
	// Show one book
	@RequestMapping("/show/{bookId}")
	public String showOne(Model model, @PathVariable("bookId") Long bookId ) {
		Book book = bookService.findBook(bookId);
				
		model.addAttribute("book", book);
		
		return "showone.jsp";
	}
	
	// Show all books
	@RequestMapping("/books")
	public String books(Model model) {
		List<Book> allBooks = bookService.allBooks();
		model.addAttribute("bookList", allBooks); // passing variable to jsp to use for forloops
		
		return "index.jsp";
	}

}
