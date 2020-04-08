package com.revature.models;

import com.revature.models.Deck;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@Column
	@ManyToMany(mappedBy = "mtg_decks", fetch = FetchType.LAZY)
	private List<Deck> decks;

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Card(int id, String type, String text, String mana, int power, int toughness, List<Deck> decks) {
		super();
		this.id = id;
		this.type = type;
		this.text = text;
		this.mana = mana;
		this.power = power;
		this.toughness = toughness;
		this.decks = decks;
	}

	public Card(String type, String text, String mana, int power, int toughness, List<Deck> decks) {
		super();
		this.type = type;
		this.text = text;
		this.mana = mana;
		this.power = power;
		this.toughness = toughness;
		this.decks = decks;
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

	public List<Deck> getDecks() {
		return decks;
	}

	public void setDecks(List<Deck> decks) {
		this.decks = decks;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", type=" + type + ", text=" + text + ", mana=" + mana + ", power=" + power
				+ ", toughness=" + toughness + ", decks=" + decks + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((decks == null) ? 0 : decks.hashCode());
		result = prime * result + id;
		result = prime * result + ((mana == null) ? 0 : mana.hashCode());
		result = prime * result + power;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + toughness;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (decks == null) {
			if (other.decks != null)
				return false;
		} else if (!decks.equals(other.decks))
			return false;
		if (id != other.id)
			return false;
		if (mana == null) {
			if (other.mana != null)
				return false;
		} else if (!mana.equals(other.mana))
			return false;
		if (power != other.power)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (toughness != other.toughness)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
}
