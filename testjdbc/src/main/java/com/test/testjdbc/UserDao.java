// this class is created to demonstrate data hnaling without database for working on rest api
package com.test.testjdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.test.testjdbc.jpa.Users;

@Component

public class UserDao {
	private Users us;
	
	List<Users>Allusers= new ArrayList<Users>(Arrays.asList(new Users(2,"Srinika",LocalDate.now().minusYears(6)),new Users(3,"Sirish",LocalDate.now().minusYears(35)),new Users(1,"Sruti",LocalDate.now().minusYears(30))));
	

	
	//Allusers.add(new Users(2,"Srinika",LocalDate.now().minusYears(6)));
	//Allusers.add(new Users(3,"Sirish",LocalDate.now().minusYears(35)));
	
	public List<Users> getAllUsers(){
		 return Allusers;
	}

	public Users getUser(int ID){
		return Allusers.stream()
		 .filter(s->s.getID()==ID)
		 .findFirst().orElse(null);
		 
		 
	}

	public void deleteUser(int iD) {
		// TODO Auto-generated method stub
		Allusers.removeIf(s->s.getID()==iD);
				
	}
	
	public Users saveUser(Users u)
	{
		Allusers.add(new Users(Allusers.stream().max((s1,s2)->s1.getID()-s2.getID()).get().getID()+1,u.getName(),u.getDateOfBirth()));
	return Allusers.stream().max((s1,s2)->s1.getID()-s2.getID()).get();
	} 
}
