package com.nerdery.snafoo.model.view;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * View model object for rendering snack model to the view.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SnackShopViewModel {
	
	private List<SnackViewModel> snacks = new ArrayList<SnackViewModel>();
	
	public SnackShopViewModel(){
	}

	public void add(SnackViewModel sm) {
		snacks.add(sm);
	}

	public List<SnackViewModel> getSnacks() {
		return snacks;
	}

	public void setSnacks(List<SnackViewModel> snacks) {
		this.snacks = snacks;
	}
}