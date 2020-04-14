package com.revature.repositories;


import java.util.Optional;

import com.revature.models.User;

public interface UserDAO {

	public Optional<User> findByEmail(String email);
	
	public void insert(User u);
	
	public void update(User u);
	
	public void delete(User u);
}
