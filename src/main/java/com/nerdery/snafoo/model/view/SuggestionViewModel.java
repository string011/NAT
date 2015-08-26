package com.nerdery.snafoo.model.view;

/**
 * View model object for rendering a model data to the view.
 */
public class SuggestionViewModel {

    private String name;
    private String location = "Never";
    private Integer voteCount = 0;
    
	public String getLocation() {
		return location;
	}
	public void setLastPurchaseDate(String lastPurchaseDate) {
		this.location = lastPurchaseDate;
	}
	public Integer getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}
	public void incrementVoteCount(){
		voteCount++;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}