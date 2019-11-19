//package net.codejava.hibernate.HibernateJPA;
package com.jwt.hibernate.bean;
//package net.codejava.hibernate;
//import javax.persistence.*;

//@Entity
//@Table(name = "USERS")
public class user {

/**
package net.codejava.hibernate;
 * User.java
 * Copyright by CodeJava.net
 */
    private String username;
    private String password;
 
//    @Column(name = "USENAME")
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}