package com.revature.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import com.revature.models.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public User findByEmail(String email) {
		String hql = "FROM User AS u WHERE u.email = :email";
		Session s  = sf.getCurrentSession();
		
		Query<User> query = s.createQuery(hql);
		
		query.setParameter("email", email);
		
		List<User> results = query.list();
		return results.get(0);
	}

	@Override
	public void insert(User u) {
		Session s = sf.getCurrentSession(); 
		s.save(u);
		
		
	}

	@Override
	public void update(User u) {
		Session s = sf.getCurrentSession(); 
		s.update(u);
		
	}

	@Override
	public void delete(User u) {
		Session s = sf.getCurrentSession(); 
		s.delete(u);
		
	}

}
