package com.example.projectmanager.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.projectmanager.models.User;

public interface UserRepository extends CrudRepository<User,Long> {
	Optional<User> findByEmail(String email);
	
}
