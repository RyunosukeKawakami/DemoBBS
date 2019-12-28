package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="thread")
@Data
public class Thread {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="thread_title")
    private String title;
    @Column(name="author")
    private String author;
    @Column(name="create_date")
    private Date create_date;
    @Column(name="URL")
    private String url;
}