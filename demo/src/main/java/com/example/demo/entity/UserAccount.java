package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name = "user_account")
@Data
public class UserAccount{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "userid")
    private int userID;
    @NotBlank(message = "パスワードを入力してください")
    @Column(name="password", nullable=false)
    private String password;
    @NotBlank(message = "名前を入力してください")
    @Column(name="user_name", nullable=false, unique=true)
    private String userName;
}