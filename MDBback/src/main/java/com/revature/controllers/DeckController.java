package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Deck;
import com.revature.repositories.DeckDAO;

@CrossOrigin
@RestController
@RequestMapping(value="/deck")
public class DeckController {
	@Autowired
	private DeckDAO dao;
	
	@GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Deck> getDeck(@PathVariable("id") int id) {
		Deck d = dao.findById(id);
		if(d == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(d);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Deck> addDeck(@RequestBody Deck d){
		dao.insert(d);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(d);
	}
	
	@DeleteMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Deck> deleteDeck(@PathVariable("id") int id){
		Deck d = dao.findById(id);
		dao.delete(d);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	
	@PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Deck> updateDeck(@RequestBody Deck d){
		dao.insert(d);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
