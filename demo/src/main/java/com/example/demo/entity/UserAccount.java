package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user_account")
public class UserAccount implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="userid")
    private String userID;
    @Column(name="password")
    private String passward;
    @Column(name="user_name")
    private String userName;

    public void setUserID(String userID) {this.userID = userID;}
    public String getUserID() {return userID;}
    public void setPassword(String password) {this.passward = password;}
    public String getPassword() {return passward;}
    public void setUserName(String userName) {this.userName = userName;}
    public String getUserName() {return userName;}
}