package com.example.demo.service;

import java.security.Principal;
import java.util.Date;

import com.example.demo.entity.Thread;
import com.example.demo.repository.ThreadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * ThreadSave
 * ThreadControllerで受け取ったタイトル名から、ログイン名、作成日を確認して
 * DBに保存するクラス
 */
@Service
public class ThreadSave {
    @Autowired
    ThreadRepository repository;    
    UserDetails account;
    Thread thread;

    public void SaveThread(Principal principal, Thread thread) {
        Authentication auth = (Authentication)principal;
        account = (UserDetails)auth.getPrincipal();

        thread.setTitle(thread.getTitle());
        thread.setAuthor(account.getUsername());
        thread.setCreateDate(new Date());

        repository.save(thread);
    }
}