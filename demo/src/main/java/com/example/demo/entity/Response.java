package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "response")
@Data
public class Response{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "thread_id")
    private int threadId;
    @Column(name = "response_id")
    private int responseId;
    @Column(name = "author")
    private String author;
    @Column(name = "date")
    private Date date;
    @Column(name = "good_num")
    private int goodNum;
    @NotBlank(message = "文章を記述してません")
    @Size(min = 0, max = 300, message = "文字数オーバーです")
    @Column(name = "text")
    private String text;
}