package com.nerdery.snafoo.services;

public class WebServicePostException extends Exception {

	private static final long serialVersionUID = 520869761211234928L;
	
	private int code;
	private String reason;

	public WebServicePostException(int code, String reason) {
		this.code = code;
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
