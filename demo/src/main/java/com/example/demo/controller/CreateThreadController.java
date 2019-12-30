package com.example.demo.controller;

import com.example.demo.repository.ThreadRepository;
import com.example.demo.entity.Thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * TopicController
 */
@Controller
public class TopicController {
    @Autowired
    ThreadRepository repository;

    @RequestMapping(value = "/createThread", method = RequestMethod.GET)
    public ModelAndView ReturnThreadView(@ModelAttribute("Thread") Thread thread, ModelAndView model) {
        model.setViewName("topic/createThread.html");
        return model;
    }

    @RequestMapping(value = "/createThread", method = RequestMethod.POST)
    public ModelAndView CreateThread(@ModelAttribute("Thread") @Validated Thread thread, BindingResult result,
            ModelAndView model) {
        if(result.hasErrors()){
            model.setViewName("topic/createThread.html");
            return model;
        }

        model.addObject();
        model.setViewName("topic/createThread.html");
        return model;
    }

}