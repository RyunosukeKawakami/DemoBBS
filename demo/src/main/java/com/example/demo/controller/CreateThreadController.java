package com.example.demo.controller;

import com.example.demo.repository.ThreadRepository;

import java.security.Principal;

import com.example.demo.entity.Thread;
import com.example.demo.service.ThreadSave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * TopicController
 */
@Controller
@RequestMapping("/topic/createThread")
public class CreateThreadController {
    @Autowired
    ThreadRepository repository;

    @Autowired
    ThreadSave save;

    @GetMapping
    public ModelAndView ReturnThreadView(@ModelAttribute("Thread") Thread thread, ModelAndView model) {
        model.setViewName("topic/createThread.html");
        return model;
    }

    /**
     * スレッドの作成、保存をする。
     * @param thread
     * @param result バリデーションチェック
     * @param model
     * @param principal ログイン中のユーザ情報を受け取る
     * @return
     */
    @PostMapping
    public ModelAndView CreateThread(@ModelAttribute("Thread") @Validated Thread thread, BindingResult result,
            ModelAndView model, Principal principal) {
        
        if (result.hasErrors()) {
            model.addObject("Thread", thread);
            model.setViewName("topic/createThread.html");
        } else {
            // データベースにスレッドを保存する
            save.SaveThread(principal, thread);

            model.addObject("Thread", thread);
            model.setViewName("redirect:/topic");
        }
        return model;
    }

}