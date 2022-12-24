package com.example.onetomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onetomany.models.User;
import com.example.onetomany.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	// Create user
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	// Find One User
	public User oneUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent() ) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	// All Users
	public List<User> allUsers() {
		return userRepo.findAll();
	}
	
}
