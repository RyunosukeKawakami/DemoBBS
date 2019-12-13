package com.example.demo.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReturnPageController {
    @RequestMapping(value = "/index.html")
    public Resource ReturnHomeHTML() {
        return new ClassPathResource("index.html");
    }

    @RequestMapping(value = "topic/index.html")
    public Resource ReturnTopicHTML() {
        return new ClassPathResource("topic/index.html");
    }

    @RequestMapping(value = "contact/index.html")
    public Resource ReturnContactHTML() {
        return new ClassPathResource("contact/index.html");
    }
}
    