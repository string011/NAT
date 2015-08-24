package com.nerdery.snafoo.model.domain.rest;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class SuggestionPageModel {

	private String name = "snaussage";
	private String location = "petco";

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
}