package com.revature.repositories;

import com.revature.models.Deck;

public interface DeckDAO {
	public Deck findById(int id);
	
	public void delete(Deck d);
	
	public void insert(Deck d);
	
	public void update(Deck d);

}
