package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

@CrossOrigin
@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private UserDAO dao;
	
	@GetMapping(value = "/{email}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findById(@PathVariable String email) {
		User u = dao.findByEmail(email);
		if(u == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(u);
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User u){
		dao.insert(u);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
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
