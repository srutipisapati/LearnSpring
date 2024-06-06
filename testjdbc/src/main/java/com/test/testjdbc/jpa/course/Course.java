package com.test.testjdbc.jpa.course;

import org.springframework.stereotype.Component;

@Component
public class Course {
	
	int Id;
	String Author;
	String Name;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return "Course [Id=" + Id + ", Author=" + Author + ", Name=" + Name + "]";
	}

}
