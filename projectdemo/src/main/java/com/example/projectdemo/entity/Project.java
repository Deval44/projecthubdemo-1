package com.example.projectdemo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "owner")
	private User owner;
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = CascadeType.ALL)
	@JoinTable(name = "project_tag",
			joinColumns = { @JoinColumn(name = "project_id")},
			inverseJoinColumns = { @JoinColumn(name = "tag_id")}
			)
	private Set<Tag> tags = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.LAZY,
		      cascade = CascadeType.ALL)
	@JoinTable(name = "project_member",
			joinColumns = { @JoinColumn(name = "project_id")},
			inverseJoinColumns = { @JoinColumn(name = "user_id")}
			)
	private Set<User> members = new HashSet<>();

	public Project() {
	}

	public Project(String name) {
		this.name = name;
	}
	
	public void addTag(Tag tag) {
		tags.add(tag);
	}
	
	public void addMember(User user) {
		members.add(user);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Set<User> getMembers() {
		return members;
	}

	public void setMembers(Set<User> members) {
		this.members = members;
	}

	
	
}
