package com.mnithelp.projecthub.projection;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.example.projectdemo.entity.Project;
import com.example.projectdemo.entity.Tag;
import com.example.projectdemo.entity.User;

@Projection(name = "projectProjection", types = Project.class)
public interface ProjectProjection {

	int getId();
	
	String getName();
	List<Tag> getTags();
	User getOwner();
	List<User> getMembers();
}
