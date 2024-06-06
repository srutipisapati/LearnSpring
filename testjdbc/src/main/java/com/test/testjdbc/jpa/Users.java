package com.test.testjdbc.jpa;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity(name = "jpatest")
public class Users {
@Id 
private int ID;
//@Min(value = 2,message = "Name should have minimum 2 characters")
private String Name;
//@Past(message = "Date of birth should not be from future")
private LocalDate DateOfBirth;
@OneToMany(mappedBy ="user")
private List<Post> post;
public Users() {
	
}

public Users(int iD, String name, LocalDate dateOfBirth) {
	super();
	ID = iD;
	Name = name;
	DateOfBirth = dateOfBirth;
}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public LocalDate getDateOfBirth() {
	return DateOfBirth;
}
public void setDateOfBirth(LocalDate dateOfBirth) {
	DateOfBirth = dateOfBirth;
}

public List<Post> getPost() {
	return post;
}

public void setPost(List<Post> post) {
	this.post = post;
}

@Override
public String toString() {
	return "Users [ID=" + ID + ", Name=" + Name + ", DateOfBirth=" + DateOfBirth + "]";
}


}
