package com.nerdery.snafoo.model.domain.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 * Example domain model object with a few persistence annotations. It can be
 * safely deleted once you have implemented your own model class(es).
 */
@Entity
public class SnackShopJPAModel implements Serializable {

	private static final long serialVersionUID = -5987956919233977335L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String location = "MN";

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinTable(name = "snack_shop_snack", joinColumns = { @JoinColumn(name = "shop_id") }, inverseJoinColumns = {
			@JoinColumn(name = "snack_id") })
	List<SnackJPAModel> snacks = new ArrayList<SnackJPAModel>();

	public SnackShopJPAModel() {
	}

	public SnackShopJPAModel(String name, int hours, int developers) {
		this.name = name;
		for (int idx = 0; idx < developers; ++idx) {
			snacks.add(new SnackJPAModel("SnackJPAModel" + String.valueOf(developers), false));
		}
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SnackJPAModel> getSnacks() {
		return snacks;
	}

	public void add(SnackJPAModel snack) {
		getSnacks().add(snack);
	}
}
