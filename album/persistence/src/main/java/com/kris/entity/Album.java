package com.kris.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Album {
	
	@Id
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	@Column(name = "owner", nullable = false, unique = true)
	private String owner;

	@OneToMany
	private List<Picture> pictures;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}