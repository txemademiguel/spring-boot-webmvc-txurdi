package com.fptxurdinaga.springbootmvc.domain.complex;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
@ToString
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;

    private List<UserGroup> userGroups = new ArrayList<UserGroup>();

    public User() {
    	this.username = "admin";
        this.password = "admin";
        this.email = "email@admin.com";
    }

    public User(String username, String password, String email) {
    	this.username = username;
        this.password = password;
        this.email = email;
    }

    public void addGroup(UserGroup group) {
        this.userGroups.add(group);
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "user")
    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> groups) {
        this.userGroups = groups;
    }

    public void addUserGroup(UserGroup userGroup) {
        this.userGroups.add(userGroup);
    }

}