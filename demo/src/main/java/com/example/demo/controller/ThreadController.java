package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.Response;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ThreadController {

    @Autowired
    List<Response> response;

    @GetMapping
    public ModelAndView ReturnThreadDetails(@PathVariable int id, ModelAndView model) {
        model.addObject("ResponseList", response);
        model.setViewName("topic/thread.html");
        return model;
    }

}