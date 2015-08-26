package com.nerdery.snafoo.controllers;

public class SnackNotFoundException extends Exception {
	
	private String name;
	
	public SnackNotFoundException(String name){
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
