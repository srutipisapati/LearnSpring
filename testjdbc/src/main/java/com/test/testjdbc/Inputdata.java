package com.test.testjdbc;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.test.testjdbc.jpa.Users;

@Component

public class Inputdata implements CommandLineRunner {
@Autowired
	JPAforusers jdbc;
@Override
public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
Users test=new Users(3,"srinika",LocalDate.now());
Users test1=new Users(2,"sruti",LocalDate.now());
jdbc.save(test);
jdbc.save(test1);
		
}

}
