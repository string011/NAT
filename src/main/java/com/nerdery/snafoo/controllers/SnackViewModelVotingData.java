package com.nerdery.snafoo.controllers;

import java.io.Serializable;

public class SnackViewModelVotingData implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id = "0";
	private String voteCount = "0";
	private String name = "none";
	
	public SnackViewModelVotingData(){
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(String voteCount) {
		this.voteCount = voteCount;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
