package com.kris.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import com.kris.entity.Album;
import com.kris.entity.User;

public class AlbumDAO {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("web");
	private EntityManager em = factory.createEntityManager();

	public Album getAlbum() {
		try {
			Album album = (Album) em;
			
			return album;
		} catch (NoResultException e) {
			return null;
		}
	}

	public Album createAlbum(Album album) {
		try {
			em.persist(album);
			return album;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Album deleteAlbum(Album album) {
		try {
			em.remove(album);
			return album;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
