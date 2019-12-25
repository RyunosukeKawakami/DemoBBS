package com.example.demo.controller;

import com.example.demo.repository.UserAccountRepository;
import com.example.demo.entity.UserAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController{
    @Autowired
    UserAccountRepository userAccountRepository;    

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public ModelAndView ReturnView(@ModelAttribute("UserAccount") UserAccount account, ModelAndView model) {
        model.addObject("UserAccount", account);
        model.setViewName("login/index.html");
        return model;
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ModelAndView Login(@ModelAttribute("UserAccount") @Validated UserAccount account, BindingResult result,
            ModelAndView model) {
        if (result.hasErrors()) {

            model.setViewName("login/index.html");
        }
        model.setViewName("forward:loginProcess");
        return model;
    }
    
    @RequestMapping(value="/login/successful")
    public ModelAndView loginSuccessfulView(ModelAndView model) {
        model.setViewName("login/successful.html");
        return model;
    }
}