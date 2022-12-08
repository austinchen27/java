package com.example.mvc.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.models.Book;
import com.example.mvc.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;

	// Constructor (select all)
	public BooksApi(BookService bookService) {
		// super(); <-- when to remove super?
		this.bookService = bookService;
	}
	
	// Find ALL books on url
	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookService.allBooks(); // find all method and returns all books
	}
	
	// Create a book
	@PostMapping("/")
	public Book create(
			@RequestParam(value="title") String title,
			@RequestParam(value="description" ) String description,
			@RequestParam(value="language") String language,
			@RequestParam(value="pages") Integer numOfPages
			) {
		Book book = new Book(title, description, language, numOfPages);
		return bookService.createBook(book);
	}
	
	// Delete a book
	@DeleteMapping("/api/books/{id}")
	public void destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
	
	// Update a book
	@PutMapping("/api/books/{id}")
	public Book update(
			@PathVariable("id") Long id,
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String description,
			@RequestParam(value="language") String language,
			@RequestParam(value="pages") Integer numOfPages
			) {
		Book book = new Book(title, description, language, numOfPages);
		book.setId(id);
		
		book = bookService.updateBook(book);
		
		return book;
	}
	
	
	// Find book by id on url
	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}
	
}
