package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Card;
import com.revature.repositories.CardDAO;


@CrossOrigin
@RestController
@RequestMapping(value="/card")
public class CardController {
	@Autowired
	private CardDAO dao;
	
	@GetMapping("/{id}")
	public ResponseEntity<Card> getCard(@PathVariable("id") int id) {
		Card c = dao.findById(id);
		if(c == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(c);
	}
	
//	@GetMapping("/byDeck/{id}")
//	public ResponseEntity<List<Card>> getCardByDeck(@PathVariable("id") Deck d) {
//		List<Card> c = dao.findByDeck(d);
//		if(c == null) {
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(c);
//	}
	@CrossOrigin
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Card> addCard(@RequestBody Card c){
		dao.insert(c);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(c);
	}
	
	@DeleteMapping
	public ResponseEntity<Card> deleteCard(@RequestBody Card c){
		dao.delete(c);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(c);
	}
	
}
