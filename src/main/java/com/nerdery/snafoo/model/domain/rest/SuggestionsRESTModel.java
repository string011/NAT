package com.nerdery.snafoo.model.domain.rest;

import java.util.List;

public class SuggestionsRESTModel {
	
	List<SuggestionRESTModel> suggestions;

	public List<SuggestionRESTModel> getSuggestions() {
		return suggestions;
	}

	public void setSnacks(List<SuggestionRESTModel> snacks) {
		this.suggestions = snacks;
	}

}
