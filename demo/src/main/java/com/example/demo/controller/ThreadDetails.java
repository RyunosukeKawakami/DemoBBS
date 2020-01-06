package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ThreadDetails
 */
@RequestMapping(path = "/topic/thread/{id}")
@Controller
public class ThreadDetails {
    @GetMapping
    public ModelAndView ReturnThreadDetails(@PathVariable int id, ModelAndView model) {
        model.setViewName("topic/thread.html");
        return model;
    }

}