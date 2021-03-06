package com.nerdery.snafoo.model.view;

/**
 * View model object for rendering a model data to the view.
 */
public class SnackViewModel {

    private Long id;
    private String name;
    private Boolean optional;
    private String purchaseLocations;
    private Integer purchaseCount = 0;
    private String lastPurchaseDate = "Never";
    private Integer voteCount = 0;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getOptional() {
		return optional;
	}
	
	public void setOptional(Boolean optional) {
		this.optional = optional;
	}
	
	public boolean isOptional(){
		return optional.booleanValue();
	}
	
	public String getPurchaseLocations() {
		return purchaseLocations;
	}
	
	public void setPurchaseLocations(String purchaseLocations) {
		this.purchaseLocations = purchaseLocations;
	}
	
	public Integer getPurchaseCount() {
		return purchaseCount;
	}
	
	public void setPurchaseCount(Integer purchaseCount) {
		this.purchaseCount = purchaseCount;
	}
	
	public String getLastPurchaseDate() {
		return lastPurchaseDate;
	}
	
	public void setLastPurchaseDate(String lastPurchaseDate) {
		this.lastPurchaseDate = lastPurchaseDate;
	}
	
	public Integer getVoteCount() {
		return voteCount;
	}
	
	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}
	
	public void incrementVoteCount(){
		++voteCount;
	}

	public boolean isPurchased() {
		return getPurchaseCount().intValue() != 0;
	}
	
	public String toString(){
		return "SnackViewModel: " + name + " votes: " + getVoteCount();
		
	}
}