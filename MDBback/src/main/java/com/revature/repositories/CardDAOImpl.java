package com.revature.repositories;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Card;
import com.revature.models.Deck;

@Repository
@Transactional
public class CardDAOImpl implements CardDAO {
	@Autowired
	private SessionFactory sf;

	@Override
	public Card findById(int id) {
		Session s = sf.getCurrentSession();
		Card c = s.get(Card.class, id);
		return c;
	}

	@Override
	public List<Card> findByDeck(Deck d) {
		Session s = sf.getCurrentSession();
		String hql = "FROM mtg_cards INNER JOIN deck_join ON id = card_id WHERE deck_id = " + d.getId();
		Query query = s.createQuery(hql);
		List<Card> res = (List<Card>) query.getResultList();
		return res;
	}

	@Override
	public void delete(Card c) {
		Session s = sf.getCurrentSession();
		s.delete(c);
		
	}

	@Override
	public void insert(Card c) {
		Session s = sf.getCurrentSession();
		s.save(c);
		
	}

	@Override
	public void update(Card c) {
		Session s = sf.getCurrentSession();
		s.update(c);
	}

}
