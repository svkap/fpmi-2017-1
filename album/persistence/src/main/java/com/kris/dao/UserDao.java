package com.kris.dao;

import com.kris.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class UserDao {
	
  private EntityManagerFactory factory = Persistence.createEntityManagerFactory("web");
  private EntityManager em = factory.createEntityManager();

  public User getUser(String nameUser, String password) {
    try {
      User user = (User) em
          .createQuery("SELECT u from User u where u.nameUser = :name and u.password = :password")
          .setParameter("name", nameUser).setParameter("password", password).getSingleResult();
      return user;
    } catch (NoResultException e) {
      return null;
    }
  }

  public User insertUser(User user) {
    try {
      em.persist(user);
      return user;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public boolean deleteUser(User user) {
    try {
      em.remove(user);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}