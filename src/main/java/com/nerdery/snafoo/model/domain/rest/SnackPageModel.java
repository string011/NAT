package com.nerdery.snafoo.model.domain.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Domain model object to handle JSON unmarshalled data. 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SnackPageModel {

    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("optional")
    private Boolean optional;
    
    @JsonProperty("purchaseLocations")
    private String purchaseLocations;
    
    @JsonProperty("purchaseCount")
    private Integer purchaseCount;
    
    @JsonProperty("lastPurchaseDate")
    private String lastPurchaseDate;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
}