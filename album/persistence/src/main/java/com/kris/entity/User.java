package com.kris.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
public class User {
  @Id
  @Column(name = "id", nullable = false, unique = true)
  private int id;
  @Column(name = "userName", nullable = false, unique = true)
  private String nameUser;
  @Column(name = "password", nullable = false, unique = false)
  private String password;
  @Column(name = "lastAccess", unique = true)
  @Temporal(TemporalType.DATE)
  private Date lastAccess;
  
  @OneToMany
  private List<Album> albums;

  public String getNameUser() {
    return nameUser;
  }

  public void setNameUser(String nameUser) {
    this.nameUser = nameUser;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getLastAccess() {
    return lastAccess;
  }

  public void setLastAccess(Date lastAccess) { this.lastAccess = lastAccess; }
}