package com.example.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookclub.models.Book;
import com.example.bookclub.models.User;
import com.example.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	// Create Book
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	// Find One Book
	public Book oneBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	// All Books
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	// Borrow a book
	public void addBorrower(Book book, User user) {
		book.setBorrower(user);
		bookRepo.save(book);
	}
	
	// Delete(returning) a book
	public void delBorrower(Book book, User user) {
		book.setBorrower(null);
		bookRepo.save(book);
	}
	
	// Delete a book
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}

}
