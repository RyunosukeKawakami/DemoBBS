package com.example.demo.controller;

import java.util.List;

import com.example.demo.repository.ThreadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * TopicController
 */
@Controller
public class TopicController {
    @Autowired
    ThreadRepository repository;
    
    List<Thread> threadList;

    @RequestMapping(value = "/topic")
    public ModelAndView ReturnTopicHTML(ModelAndView model) {
        threadList = repository.findAll();

        model.addObject("ThreadList", threadList);
        model.setViewName("topic/index.html");
        return model;
    }    
}