package com.test.testjdbc;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.testjdbc.jpa.Users;

public interface JPAforusers extends JpaRepository<Users, Integer>{

}
