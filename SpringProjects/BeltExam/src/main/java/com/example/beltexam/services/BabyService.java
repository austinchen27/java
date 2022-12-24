package com.example.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beltexam.models.Baby;
import com.example.beltexam.models.User;
import com.example.beltexam.repositories.BabyRepository;
import com.example.beltexam.repositories.UserRepository;

@Service
public class BabyService {
	
	@Autowired
	private BabyRepository babyRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	// Create Baby Name
	public Baby createBaby(Baby baby) {
		//BindingResult result
//    	Optional<Baby> optionalBaby = babyRepo.findById(baby.getId());
//    	if(optionalBaby.isPresent()) {
//    		result.rejectValue("name", "unique", "This name is already registered");
//    	}
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
	
	// === BLACK BELT ===
	public List<Baby> getUnassignedUsers(User user){
		return babyRepo.findByUsersNotContains(user);
	}
	
	// UPVOTE
	public Baby upvote(Long projectId, Object userId) {
		Baby baby = babyRepo.findById((Long) projectId).get();
		User user = userRepo.findById((Long) userId).get();
		baby.getUsers().add(user);
		babyRepo.save(baby);
		return baby;
	}
	
    public Baby downvote(Long babyId, Object userId) {
    	Baby baby = babyRepo.findById((Long) babyId).get();
    	User user = userRepo.findById((Long) userId).get();
    	user.getUpvotes().remove(baby);
    	userRepo.save(user);
    	return baby;
    }
	
	
}
