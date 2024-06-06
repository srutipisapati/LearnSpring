package com.test.testjdbc.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.testjdbc.jpa.course.Course;

@Repository
public class Calljdbc {
@Autowired
	private JdbcTemplate springjdbc;
	
	private static String query=
			""" 
			insert into course(id,author,name) values(?,?,?);
			""";
	
	private static String query1=
			""" 
			delete from course where id=?;
			""";
	
	private static String query2=
			""" 
			select * from course where id= ?;
			""";
	
	public void insertdb(Course course) {
		springjdbc.update(query,course.getId(),course.getAuthor(),course.getName());
	}
	
	public void deletebyId(long id) {
		springjdbc.update(query1,id);
	}
	
	public List<Course> findbyId(long id) {
		return springjdbc.query(query2,new BeanPropertyRowMapper<>(Course.class),id);
	}
}
