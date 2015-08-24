package com.nerdery.snafoo.model.view;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * View model object for rendering suggestions model to the view.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuggestionsModel {
	
	private List<SuggestionModel> suggestions = new ArrayList<SuggestionModel>();
	
	// Name and location are used when the form/model is sent via a post.
	private String name;
	private String location;
	
	public SuggestionsModel(){
	}

	public void add(SuggestionModel sm) {
		suggestions.add(sm);
	}

	public List<SuggestionModel> getSuggestions() {
		return suggestions;
	}

	public void setSnacks(List<SuggestionModel> snacks) {
		this.suggestions = snacks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setSuggestions(List<SuggestionModel> suggestions) {
		this.suggestions = suggestions;
	}
}