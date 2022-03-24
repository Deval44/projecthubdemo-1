package com.example.projectdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectdemo.entity.Project;
import com.example.projectdemo.entity.Tag;
import com.example.projectdemo.entity.User;
import com.example.projectdemo.repository.ProjectRepository;
import com.example.projectdemo.repository.TagRepository;
import com.example.projectdemo.repository.UserRepository;

@RestController
@RequestMapping("custom/api/projects")
public class ProjectRestController {

	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	TagRepository tagRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@PutMapping("/{projectId}/tags/{tagId}")
	Project addProjectTag(
				@PathVariable Integer projectId,
				@PathVariable Integer tagId
			) 
	{
		Project project = projectRepository.findById(projectId).get();
		Tag tag = tagRepository.findById(tagId).get();
		
		project.addTag(tag);
		return projectRepository.save(project);
	}
	
	@PutMapping("/{projectId}/users/{userId}")
	Project addProjectOwner(
				@PathVariable Integer projectId,
				@PathVariable Integer userId
			) 
	{
		Project project = projectRepository.findById(projectId).get();
		User owner = userRepository.findById(userId).get();
		
		project.setOwner(owner);
		return projectRepository.save(project);
	}
	
	@PutMapping("/{projectId}/members/{userId}")
	Project addProjectMember(
				@PathVariable Integer projectId,
				@PathVariable Integer userId
			) 
	{
		Project project = projectRepository.findById(projectId).get();
		User member = userRepository.findById(userId).get();
		
		project.addMember(member);
		return projectRepository.save(project);
	}
}
