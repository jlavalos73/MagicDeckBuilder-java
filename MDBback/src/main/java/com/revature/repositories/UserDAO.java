package com.revature.repositories;


import com.revature.models.User;

public interface UserDAO {

	public User findByEmail(String email);
	
	public void insert(User u);
	
	public void update(User u);
	
	public void delete(User u);
}
