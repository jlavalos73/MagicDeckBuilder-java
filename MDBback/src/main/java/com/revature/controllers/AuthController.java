package com.revature.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.models.templates.LoginTemplate;
import com.revature.repositories.UserDAO;
import com.revature.services.SecurityService;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	private UserDAO udao;

	@Autowired
	private SecurityService sec;

	@PostMapping
	public ResponseEntity<User> login(@RequestBody LoginTemplate lt) {

		Optional<User> optUser = udao.findByEmail(lt.getEmail());

		if (optUser.isPresent()) // proceed when user found
		{
			User user = optUser.get();
			System.out.println(user);
			boolean valid = sec.checkPassword(lt.getPassword(), user.getPassword());
			if (valid) {
				return ResponseEntity.status(HttpStatus.OK).body(user);
			}
		}
		return ResponseEntity.badRequest().build();// Response if user is not found

	}
	
	@GetMapping(value = "/{email}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findById(@PathVariable String email) {
		Optional<User> userOption = udao.findByEmail(email);
		if(userOption.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(userOption.get());			
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	

}
