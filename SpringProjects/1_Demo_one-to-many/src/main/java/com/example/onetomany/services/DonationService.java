package com.example.onetomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onetomany.models.Donation;
import com.example.onetomany.repositories.DonationRepository;

@Service
public class DonationService {

	@Autowired
	private DonationRepository donationRepo;
	
	public Donation createDonation(Donation donation) {
		return donationRepo.save(donation);
	}
	
	// Find All Donations Method
	public List<Donation> allDonations(){
		return donationRepo.findAll();
	}
	
	// Find One Donation
	public Donation oneDonation(Long id) {
		Optional<Donation> optionalDonation = donationRepo.findById(id);
		if(optionalDonation.isPresent()) {
			return optionalDonation.get();
		} else {
			return null;
		}
	}
	
	// Edit
	public Donation editDonation(Donation donation) {
		return donationRepo.save(donation);
	}
	
	// Delete
	public void deleteDonation(Long id)  {
		donationRepo.deleteById(id);
	}
}
