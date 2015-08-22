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

public class ExampleProjectModel implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int hours;

	@Column(nullable = false)
	private int developers;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinTable(name = "MODEL_MODEL2", joinColumns = { @JoinColumn(name = "model_id") }, inverseJoinColumns = {
			@JoinColumn(name = "model2_id") })
	List<ExampleProjectModel2> models = new ArrayList<ExampleProjectModel2>();

	public List<ExampleProjectModel2> getModels() {
		return models;
	}

	public void setModels(List<ExampleProjectModel2> models) {
		this.models = models;
	}

	public ExampleProjectModel() {
	}

	public ExampleProjectModel(String name, int hours, int developers) {
		this.name = name;
		this.hours = hours;
		this.developers = developers;
		for (int idx = 0; idx < developers; ++idx) {
			models.add(new ExampleProjectModel2("NAME" + String.valueOf(developers)));
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

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getDevelopers() {
		return developers;
	}

	public void setDevelopers(int developers) {
		this.developers = developers;
	}
}
