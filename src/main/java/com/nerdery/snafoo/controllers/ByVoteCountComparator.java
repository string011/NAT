package com.nerdery.snafoo.controllers;

import java.util.Comparator;

import com.nerdery.snafoo.model.view.SnackViewModel;

public class ByVoteCountComparator<T extends SnackViewModel> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		if (o1.isOptional() && o2.isOptional()){
			int comp = o1.getVoteCount().compareTo((o2.getVoteCount()));
			if (comp != 0){
				return comp;
			}
		}
		return defaultCompare(o1, o2);
	}
	
	private int defaultCompare(T o1, T o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
