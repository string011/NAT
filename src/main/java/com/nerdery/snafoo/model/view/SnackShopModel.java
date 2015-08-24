package com.nerdery.snafoo.model.view;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * View model object for rendering snack model to the view.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SnackShopModel {
	
	private List<SnackModel> snacks = new ArrayList<SnackModel>();
	
	public SnackShopModel(){
	}

	public void add(SnackModel sm) {
		snacks.add(sm);
	}

	public List<SnackModel> getSnacks() {
		return snacks;
	}

	public void setSnacks(List<SnackModel> snacks) {
		this.snacks = snacks;
	}
}