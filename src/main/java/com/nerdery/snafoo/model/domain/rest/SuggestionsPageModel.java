package com.nerdery.snafoo.model.domain.rest;

import java.util.List;

public class SuggestionsPageModel {
	
	List<SuggestionPageModel> suggestions;

	public List<SuggestionPageModel> getSuggestions() {
		return suggestions;
	}

	public void setSnacks(List<SuggestionPageModel> snacks) {
		this.suggestions = snacks;
	}

}
