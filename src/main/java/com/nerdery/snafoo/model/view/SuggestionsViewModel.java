package com.nerdery.snafoo.model.view;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * View model object for rendering suggestions model to the view.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuggestionsViewModel {
	
	private List<SuggestionViewModel> suggestions = new ArrayList<SuggestionViewModel>();
	
	// Name and location are used when the form/model is sent via a post.
	private String name;
	private String location;
	
	public SuggestionsViewModel(){
	}

	public void add(SuggestionViewModel sm) {
		suggestions.add(sm);
	}

	public List<SuggestionViewModel> getSuggestions() {
		return suggestions;
	}

	public void setSnacks(List<SuggestionViewModel> snacks) {
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

	public void setSuggestions(List<SuggestionViewModel> suggestions) {
		this.suggestions = suggestions;
	}
}