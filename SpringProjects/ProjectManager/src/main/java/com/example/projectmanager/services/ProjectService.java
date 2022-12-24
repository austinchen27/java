package com.example.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectmanager.models.Project;
import com.example.projectmanager.models.User;
import com.example.projectmanager.repositories.ProjectRepository;
import com.example.projectmanager.repositories.UserRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	// Create Project
	public Project createProject(Project project) {
		return projectRepo.save(project);
	}
	
	// Find One Project
	public Project oneProject(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		} else {
			return null;
		}
	}
	
	// All Projects
	public List<Project> allProjects(){
		return projectRepo.findAll();
	}
	
	// Delete a book
	public void deleteBook(Long id) {
		projectRepo.deleteById(id);
	}
	
	// Edit/Update/Save a Project
	public Project save(Project project) {
		return projectRepo.save(project);
	}
	
	// === BLACK BELT === 
	public List<Project> getUnassignedUsers(User user){
		return projectRepo.findByUsersNotContains(user);
	}
	
	// JOIN
    public Project joinTeam(Long projectId, Object userId) {
    	Project project = projectRepo.findById((Long) projectId).get();
    	User user = userRepo.findById((Long) userId).get();
    	project.getUsers().add(user);
    	projectRepo.save(project);
    	return project;
    }

}
