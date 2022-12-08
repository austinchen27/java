package com.example.mvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.models.Book;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {  //model, primary key type *id Long
	List<Book> findAll();
	List<Book> findByDescriptionContaining(String search);
}
