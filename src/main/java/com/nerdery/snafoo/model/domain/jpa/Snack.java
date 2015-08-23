package com.nerdery.snafoo.model.domain.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Example domain model object with a few persistence annotations. It can be
 * safely deleted once you have implemented your own model class(es).
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

	public boolean isAlwaysPurchased() {
		return alwaysPurchased;
	}

	public void setAlwaysPurchased(boolean alwaysPurchased) {
		this.alwaysPurchased = alwaysPurchased;
	}

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
}
