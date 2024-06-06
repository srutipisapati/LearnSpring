package com.test.testjdbc.jpa;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Post {
	@Id
	@GeneratedValue
	private long id;

	private String description;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Users user;
	public Post()
	{
		
	}
	public Post(long id, String description) {
		super();
		this.id = id;
		this.description = description;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;


	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Users getUser() {
		return user;


	}
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", description =" + description +  "]";
	}
	

}
