package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="thread")
@Data
public class Thread {
    @Id
    @Column(name="id")
    private int id;
    @NotBlank(message = "タイトルを入力してください")
    @Size(min = 1, max = 30 , message = "文字数オーバーです")
    @Column(name="thread_title")
    private String title;
    @Column(name="author")
    private String author;
    @Column(name="create_date")
    private Date create_date;
    @Column(name="URL")
    private String url;
}