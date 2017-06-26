package com.kris.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Picture {
	
	@Id
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	@Column(name = "name", nullable = false, unique = true)
	private String name;
	@Column(name = "album", nullable = false, unique = true)
	private String album;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlbum() {
		return name;
	}

	public void setAlbum(String album) {
		this.album = album;
	}
}