package com.example.demo.service;

import java.security.Principal;
import java.util.Date;

import com.example.demo.entity.Response;
import com.example.demo.repository.ResponseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * ResponseSave ResponseControllerで受け取ったタイトル名から、ログイン名、作成日を確認して DBに保存するクラス
 */
@Service
public class ResponseSave {
    @Autowired
    ResponseRepository repository;
    Thread thread;
    UserDetails account;
    Response response;

    public void SaveResponse(Principal principal, Response response) {
        Authentication auth = (Authentication) principal;
        account = (UserDetails) auth.getPrincipal();

        //textはModelAttributeで受け取っている
        //thread_idは外部キーなので自動でセットされてほしい・・・
        response.setText(response.getText());
        response.setGoodNum(0);
        response.setAuthor(account.getUsername());
        response.setDate(new Date());

        repository.save(response);
    }
}