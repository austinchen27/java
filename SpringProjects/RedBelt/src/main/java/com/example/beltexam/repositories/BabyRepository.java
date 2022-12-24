package com.example.beltexam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.beltexam.models.Baby;

public interface BabyRepository extends CrudRepository<Baby,Long>{
	List<Baby> findAll();
	
//	List<Baby> findByUsersNotContains(User user);
}
