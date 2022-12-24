package com.example.beltexam.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.beltexam.models.User;

public interface UserRepository extends CrudRepository<User,Long> {
	Optional<User> findByEmail(String email);
}
