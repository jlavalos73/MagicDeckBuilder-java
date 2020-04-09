package com.revature.repositories;

import org.springframework.stereotype.Repository;

import com.revature.models.User;

public interface UserDAO {

	public User findByEmail(String email);
	
}
