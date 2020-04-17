package com.revature.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.services.SecurityService;

@CrossOrigin
@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserDAO dao;

	
	@GetMapping(value = "/{email}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findById(@PathVariable String email) {
		Optional<User> userOption = dao.findByEmail(email);
		if(userOption.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(userOption.get());			
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User u){
		String raw = u.getPassword();
		u.setPassword(SecurityService.hashPassword(raw));
		dao.insert(u);
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	
	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> deleteUser(@RequestBody User u){
		dao.delete(u);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User u){
		dao.update(u);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
