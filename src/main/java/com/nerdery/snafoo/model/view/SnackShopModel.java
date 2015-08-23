package com.nerdery.snafoo.model.view;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * View model object for rendering snack model data to the view.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SnackShopModel {
	
	private List<SnackModel> snacks = new ArrayList<SnackModel>();
	
	public SnackShopModel(){
	}

	public void add(SnackModel sm) {
		snacks.add(sm);
	}
}