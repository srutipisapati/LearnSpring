package com.test.testjdbc;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.test.exceptions.UserNotFoundException;
import com.test.testjdbc.jpa.Post;
import com.test.testjdbc.jpa.Users;

import jakarta.validation.Valid;

@RestController
public class UsersController {
	
	private JPAforposts post;
	private JPAforusers use;

	public UsersController(JPAforusers use,JPAforposts post) {
		super();
	
		this.use=use;
		this.post=post;
	}
	@GetMapping(path = "/Users")
	public List<Users> retrieveAllusers()
	{
		return use.findAll();
	}
	@GetMapping(path = "/Users/{ID}")
	public Optional<Users> retrieveuser(@PathVariable int ID)
	{Optional<Users> value= use.findById(ID);
	if(value.isEmpty())
		throw new UserNotFoundException("ID is "+ ID) ;
	return value;
		
	
	}
	@DeleteMapping(path = "/Users/{ID}")
	public void deleteuser(@PathVariable int ID)
	{use.deleteById(ID);
	}
	@PostMapping(path = "/Users")
	public ResponseEntity<Users> retrieveuser( @Valid @RequestBody Users r)
	{
		Users saveduser=use.save(r);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{ID}")
					.buildAndExpand(saveduser.getID())
					.toUri();
		System.out.println(location);
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping(path = "/Users/{ID}/Posts")
	public ResponseEntity<Post> saveposts(@PathVariable int ID,@Valid @RequestBody Post posts)
	{Optional<Users> value= use.findById(ID);
	if(value.isEmpty())
		throw new UserNotFoundException("ID is "+ ID) ;
posts.setUser(value.get());
Post resultpost=post.save(posts);

URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{ID}")
				.buildAndExpand(resultpost.getId())
				.toUri();

return ResponseEntity.created(location).build();
		
	
	}
	
	@GetMapping(path = "/Users/{ID}/Posts")
	public List<Post> retrieveposts(@PathVariable int ID)
	{Optional<Users> value= use.findById(ID);
	if(value.isEmpty())
		throw new UserNotFoundException("ID is "+ ID) ;
	return value.get().getPost();
		
	
	}
}
