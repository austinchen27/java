package com.example.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.projectmanager.models.Project;
import com.example.projectmanager.models.User;

public interface ProjectRepository extends CrudRepository<Project,Long>{
	List<Project> findAll();
	
	List<Project> findByUsersNotContains(User user);
}
