package com.example.demo.controller;

import com.example.demo.repository.ThreadRepository;
import com.example.demo.entity.Thread;

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

    @GetMapping
    public ModelAndView ReturnThreadView(@ModelAttribute("Thread") Thread thread, ModelAndView model) {
        model.setViewName("topic/createThread.html");
        return model;
    }

    @PostMapping
    public ModelAndView CreateThread(@ModelAttribute("Thread") @Validated Thread thread, BindingResult result,
            ModelAndView model) {
        if (result.hasErrors()) {
            model.setViewName("topic/createThread.html");
            return model;
        }
        //データベースに保存するサービスを書く予定

        model.addObject("Thread",thread);
        model.setViewName("topic/createThread.html");
        return model;
    }

}