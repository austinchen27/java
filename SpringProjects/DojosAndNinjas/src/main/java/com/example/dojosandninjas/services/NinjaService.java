package com.example.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dojosandninjas.models.Ninja;
import com.example.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	// Find All Ninjas Method
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	// Find One Ninja
	public Ninja oneNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
}

