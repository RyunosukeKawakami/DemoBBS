package com.example.demo.controller;

import com.example.demo.repository.ResponseRepository;
import com.example.demo.repository.ThreadRepository;
import java.security.Principal;
import com.example.demo.entity.Thread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * TopicController
 */
@Controller
@RequestMapping(value = "/topic")
public class TopicController {
    @Autowired
    ThreadRepository threadRepository;
    @Autowired
    ResponseRepository responseRepository;
    Iterable<Thread> threadList;

    @GetMapping
    public ModelAndView ReturnTopicHTML(ModelAndView model, Principal Principal) {
        threadList = threadRepository.findAll();
        Authentication auth = (Authentication) Principal;
        UserDetails account = (UserDetails) auth.getPrincipal();

        model.addObject("LoginUser", account);
        model.addObject("ThreadList", threadList);
        model.setViewName("topic/index.html");
        return model;
    }
    
    @PostMapping
    public ModelAndView DeleteThread(@RequestParam("id") int id, ModelAndView model) {
        if (threadRepository.existsById(id)) {
            //スレッドのレスポンスも削除する
            responseRepository.deleteByThreadId(id);
            threadRepository.deleteById(id);
        }

        model.addObject("ThreadList", threadList);
        model.setViewName("redirect:/topic");
        return model;
    }
}