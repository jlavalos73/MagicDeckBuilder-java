package com.revature.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.revature.models.Deck;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="mtg_cards")
public class Card {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String type;
	
	@Column
	private String text;
	
	@Column
	private String mana;
	
	@Column
	private int power;
	
	@Column
	private int toughness;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn
	@JsonBackReference
	private Deck deck;

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Card(int id, String type, String text, String mana, int power, int toughness, Deck deck) {
		super();
		this.id = id;
		this.type = type;
		this.text = text;
		this.mana = mana;
		this.power = power;
		this.toughness = toughness;
		this.deck = deck;
	}

	public Card(String type, String text, String mana, int power, int toughness, Deck deck) {
		super();
		this.type = type;
		this.text = text;
		this.mana = mana;
		this.power = power;
		this.toughness = toughness;
		this.deck= deck;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMana() {
		return mana;
	}

	public void setMana(String mana) {
		this.mana = mana;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getToughness() {
		return toughness;
	}

	public void setToughness(int toughness) {
		this.toughness = toughness;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDecks(Deck decks) {
		this.deck = deck;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", type=" + type + ", text=" + text + ", mana=" + mana + ", power=" + power
				+ ", toughness=" + toughness + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(deck, id, mana, power, text, toughness, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Card)) {
			return false;
		}
		Card other = (Card) obj;
		return Objects.equals(deck, other.deck) && id == other.id && Objects.equals(mana, other.mana)
				&& power == other.power && Objects.equals(text, other.text) && toughness == other.toughness
				&& Objects.equals(type, other.type);
	}
	
	
	
}
