package com.nerdery.snafoo.model.domain.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Domain model object to handle JSON unmarshalled data. 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SnackShopPageModel {

	List<SnackPageModel> snacks;

	public List<SnackPageModel> getSnacks() {
		return snacks;
	}

	public void setSnacks(List<SnackPageModel> snacks) {
		this.snacks = snacks;
	}

}