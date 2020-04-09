package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.models.templates.LoginTemplate;
import com.revature.repositories.UserDAO;


@RestController
@RequestMapping(value="/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	private UserDAO udao;
	
	
	@PostMapping
	public ResponseEntity<User> login(@RequestBody LoginTemplate lt){
		
		User user = udao.findByEmail(lt.getEmail());
		System.out.println(user);
		//TODO: Password verification
		if(user==null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); //Response if user is not found
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
	}
	
	
}
