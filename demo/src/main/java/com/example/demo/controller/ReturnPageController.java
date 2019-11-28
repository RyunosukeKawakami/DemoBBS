package com.example.demo.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReturnPageController {
    @RequestMapping(value = "/index.html")
    public Resource ReturnHomeHTML() {
        return new ClassPathResource("index.html");
    }

    @RequestMapping(value = "Login/index.html")
    public Resource ReturnLoginHTML() {
        return new ClassPathResource("Login/index.html");
    }

    @RequestMapping(value = "Signup/index.html")
    public Resource ReturnSignupHTML() {
        return new ClassPathResource("Signup/index.html");
    }

    @RequestMapping(value = "Topic/index.html")
    public Resource ReturnTopicHTML() {
        return new ClassPathResource("Topic/index.html");
    }

    @RequestMapping(value = "Contact/index.html")
    public Resource ReturnContactHTML() {
        return new ClassPathResource("Contact/index.html");
    }
}
    