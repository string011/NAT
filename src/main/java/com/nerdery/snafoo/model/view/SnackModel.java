package com.nerdery.snafoo.model.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * View model object for rendering model data to the view.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SnackModel {

    private Integer id;
    private String name;
    private Boolean optional;
    private String purchaseLocations;
    private Integer purchaseCount;
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