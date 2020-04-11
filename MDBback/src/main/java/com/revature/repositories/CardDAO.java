package com.revature.repositories;
import com.revature.models.Card;


public interface CardDAO {
	public Card findById(int id);
	
	public void delete(Card c);
	
	public void insert(Card c);
	
	public void update(Card c);

}
