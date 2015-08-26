package com.nerdery.snafoo.model.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * View model object for rendering errors model to the view.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorModel {
	
	// Error message.
	private String errorMessage;
	
	public ErrorModel(String errorMessage){
		setErrorMessage(errorMessage);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}