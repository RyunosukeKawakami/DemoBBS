package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.security.Principal;
import java.util.Date;

import com.example.demo.entity.Thread;
import com.example.demo.repository.ThreadRepository;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * ThreadSave
 * ThreadControllerで受け取ったタイトル名から、ログイン名、作成日を確認して
 * DBに保存するクラス
 */
public class ThreadSave {
    @Autowired
    ThreadRepository repository;    
    Thread thread;
    UserAccount account;

    public void SaveThread(Principal principal, String title) {
        thread.setTitle(title);
        thread.setAuthor(principal.getName());
        thread.setCreateDate(new Date());
        //setURLを記述する予定
    }
}