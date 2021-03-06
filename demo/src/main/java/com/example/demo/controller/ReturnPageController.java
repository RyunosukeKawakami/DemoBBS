package com.example.demo.controller;

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

    @RequestMapping(value = "/contact")
    public ModelAndView returnContactHTML(ModelAndView model) {
        model.setViewName("contact/index.html");
        return model;
    }
}
    