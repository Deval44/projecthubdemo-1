package com.example.projectdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.projectdemo.entity.User;
import com.mnithelp.projecthub.projection.ProjectProjection;

@RepositoryRestResource(excerptProjection = ProjectProjection.class)
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
