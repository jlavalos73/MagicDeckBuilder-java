package com.revature.repositories;

import java.util.List;

import com.revature.models.Card;
import com.revature.models.Deck;

public interface CardDAO {
	public Card findById(int id);
	
	public List<Card> findByDeck(Deck d);
	
	public void delete(Card c);
	
	public void insert(Card c);
	
	public void update(Card c);

}
