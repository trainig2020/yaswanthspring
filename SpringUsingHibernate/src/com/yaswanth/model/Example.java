package com.yaswanth.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Example {
	@Id
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Example(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Example() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Example [id=" + id + ", name=" + name + "]";
	}

}
