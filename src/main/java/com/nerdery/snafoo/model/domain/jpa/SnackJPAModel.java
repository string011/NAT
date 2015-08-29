package com.nerdery.snafoo.model.domain.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Domain model object representing a SnackJPAModel.
 */
@Entity
public class SnackJPAModel implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private Long remoteId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private boolean alwaysPurchased = false;
	
	@Column(nullable = false)
	private int voteCount = 0;

	@Column(nullable = false)
	private boolean suggested = false;
	
	@Column(nullable = true)
	private Date suggestionDate = new Date();
	
	@Column(nullable = true)
	private String location = "none";


	@ManyToOne
	SnackShopJPAModel snackShop;


	/**
	 * Default no-arg constructor.
	 */
	public SnackJPAModel() {
	}

	/**
	 * Constructor for a new SnackJPAModel.
	 * @param name - The name of the snack.
	 * @param alwaysPurchased
	 */
	public SnackJPAModel(String name, boolean alwaysPurchased) {
		this.name = name;
		this.alwaysPurchased = alwaysPurchased;
	}

	/**
	 * Constructor for a new SnackJPAModel. Defaults to 'optionally purchased'.
	 * @param name - The name of the snack.
	 */
	public SnackJPAModel(String name) {
		this(name, false);
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
	
	public int getVoteCount() {
		return voteCount;
	}

	public void setNumberOfVotes(int numberOfVotes) {
		this.voteCount = numberOfVotes;
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

	public SnackShopJPAModel getSnackShop() {
		return snackShop;
	}

	public void incrementVoteCount() {
		++voteCount;
	}

	public Long getRemoteId() {
		return remoteId;
	}

	public void setRemoteId(Long remoteId) {
		this.remoteId = remoteId;
	}
}
