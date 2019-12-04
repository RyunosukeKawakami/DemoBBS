package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.UserAccount;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SignUpController {
    @RequestMapping(value="signup/index.html")
    public ModelAndView SignUp(@ModelAttribute @Validated UserAccount account, BindingResult result,
            ModelAndView model) {
        if (result.hasErrors()) {

        }
        model.addObject("UserAccount", account);
        model.setViewName("signup/index.html");
        return model;
    }
}