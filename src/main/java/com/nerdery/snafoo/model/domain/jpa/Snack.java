package com.nerdery.snafoo.model.domain.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Domain model object representing a Snack.
 */
@Entity
public class Snack implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private boolean alwaysPurchased = false;
	
	@Column(nullable = false)
	private int numberOfVotes = 0;

	@Column(nullable = false)
	private boolean suggested = false;
	
	@Column(nullable = true)
	private Date suggestionDate = new Date();
	
	@Column(nullable = true)
	private String location = "none";


	@ManyToOne
	SnackShop snackShop;


	public Snack() {
	}

	public Snack(String name, boolean alwaysPurchased) {
		this.name = name;
		this.alwaysPurchased = alwaysPurchased;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(int numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}
	
	public boolean isAlwaysPurchased() {
		return alwaysPurchased;
	}

	public void setAlwaysPurchased(boolean alwaysPurchased) {
		this.alwaysPurchased = alwaysPurchased;
	}

	public boolean isSuggested() {
		return suggested;
	}

	public void setSuggested(boolean suggested) {
		this.suggested = suggested;
	}

	public Date getSuggestionDate() {
		return suggestionDate;
	}

	public void setSuggestionDate(Date suggestionDate) {
		this.suggestionDate = suggestionDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public SnackShop getSnackShop() {
		return snackShop;
	}
}
