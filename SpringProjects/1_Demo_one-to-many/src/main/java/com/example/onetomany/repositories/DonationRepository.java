package com.example.onetomany.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.onetomany.models.Donation;

@Repository
public interface DonationRepository extends CrudRepository<Donation, Long> {
	List<Donation> findAll();
}
