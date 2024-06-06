package com.test.testjdbc;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.testjdbc.jpa.Post;

public interface JPAforposts extends JpaRepository<Post, Integer>{

}
