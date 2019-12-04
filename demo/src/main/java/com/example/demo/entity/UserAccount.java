package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="user_account")
public class UserAccount{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "userid")
    private int userID;
    @Column(name="password")
    private String password;
    @NotBlank
    @Column(name="user_name")
    private String userName;

    public void setUserID(int userID) {this.userID = userID;}
    public int getUserID() {return userID;}
    public void setPassword(String password) {this.password = password;}
    public String getPassword() {return password;}
    public void setUserName(String userName) {this.userName = userName;}
    public String getUserName() {return userName;}
}