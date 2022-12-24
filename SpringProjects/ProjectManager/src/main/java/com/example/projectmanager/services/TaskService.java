package com.example.projectmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectmanager.models.Project;
import com.example.projectmanager.models.Task;
import com.example.projectmanager.models.User;
import com.example.projectmanager.repositories.ProjectRepository;
import com.example.projectmanager.repositories.TaskRepository;
import com.example.projectmanager.repositories.UserRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public void createTask(Task task, Long projectId, Object userId) {
		Project project = projectRepo.findById(projectId).get();
		User user = userRepo.findById((Long) userId).get();
		task.setProject(project);
		task.setCreator(user);
		taskRepo.save(task);
	}
	
	public void createTask(Task task) {
		taskRepo.save(task);
	}

}
