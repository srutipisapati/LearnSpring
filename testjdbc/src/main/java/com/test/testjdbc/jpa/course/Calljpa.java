package com.test.testjdbc.jpa.course;



import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class Calljpa {
@PersistenceContext
	private EntityManager springjpa;
	
	
	public void insertdb(Course course) {
		springjpa.merge(course);
	}
	
	public void deletebyId(long id) {
		Course course =springjpa.find(Course.class,id);
		springjpa.remove(course);
	}
	
	public Course findbyId(long id) {
		return springjpa.find(Course.class, id);
	}
}
