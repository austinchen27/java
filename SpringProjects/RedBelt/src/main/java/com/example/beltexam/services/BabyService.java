package com.example.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beltexam.models.Baby;
import com.example.beltexam.repositories.BabyRepository;

@Service
public class BabyService {
	
	@Autowired
	private BabyRepository babyRepo;
	
//	@Autowired UserRepository userRepo;
//	private UserRepository userRepo;
	
	// Create Baby Name
	public Baby createBaby(Baby baby) {
		return babyRepo.save(baby);
	}
	
	// Find One Baby
	public Baby oneBaby(Long id) {
		Optional<Baby> optionalBaby = babyRepo.findById(id);
		if(optionalBaby.isPresent()) {
			return optionalBaby.get();
		} else {
			return null;
		}
	}
	
	// All Babies
	public List<Baby> allBabies(){
		return babyRepo.findAll();
	}
	
	// Edit/Update/Save a Baby
	public Baby save(Baby baby) {
		return babyRepo.save(baby);
	}
	
	// Delete a Baby
	public void deleteBaby(Long id) {
		babyRepo.deleteById(id);
	}
	
	
}
