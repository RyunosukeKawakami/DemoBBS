package com.example.demo.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnPageController {
    @RequestMapping(value = "/index.html")
    public ModelAndView ReturnHomeHTML(ModelAndView model) {
        model.setViewName("index.html");
        return model;
    }

    @RequestMapping(value = "/topic")
    public ModelAndView ReturnTopicHTML(ModelAndView model) {
        model.setViewName("topic/index.html");
        return model;
    }

    @RequestMapping(value = "/contact")
    public ModelAndView ieturnContactHTML(ModelAndView model) {
        model.setViewName("contact/index.html");
        return model;
    }
}
    