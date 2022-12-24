package com.example.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dojosandninjas.models.Dojo;
import com.example.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepo;
	
	
	// Create Dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
	// Find One Dojo
	public Dojo oneDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
	// All Dojos
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
}
