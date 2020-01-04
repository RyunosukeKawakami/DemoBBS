package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ThreadDetails
 */
@RequestMapping(value="/topic/thread/{id}")
public class ThreadDetails {
    @GetMapping
    public ModelAndView ReturnThreadDetails(ModelAndView model) {
        model.setViewName("/topic/thread.html");
        return model;
    }

}