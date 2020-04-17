package com.revature.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Deck;

@Repository
@Transactional
public class DeckDAOImpl implements DeckDAO {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public Deck findById(int id) {
		Session s = sf.getCurrentSession();
		Deck d = s.get(Deck.class, id);
		return d;
	}

	@Override
	public void delete(Deck d) {
		Session s = sf.getCurrentSession();
		s.delete(d);
	}

	@Override
	public void insert(Deck d) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(d);
		
	}

	@Override
	public void update(Deck d) {
		Session s = sf.getCurrentSession();
		s.update(d);
		
	}

}
