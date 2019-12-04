package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.repository.UserAccountRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.repository.UserAccountRepository;

@Controller
public class SignUpController {
    @Autowired
    UserAccountRepository userAccountRepository; 

    @RequestMapping(value="signup/index.html")
    public ModelAndView SignUp(@ModelAttribute @Validated UserAccount account, BindingResult result,
            ModelAndView model) {
        
        //入力値に問題がある場合、hasErrorsがTrueとなる。
        if (result.hasErrors()) {
            model.setViewName("signup/index.html");
        }
        else {
            //userNameが存在する場合は登録を行わず、
            //存在することを通知する。
            if (userAccountRepository.existsByUserName(account.getUserName())) {
                model.addObject("Error", "alreadyExist");
                model.setViewName("signup/index.html");
            }
            else {
                //データベースに保存する。
                userAccountRepository.saveAndFlush(account);
                model.setViewName("index.html");
            }
        }
        return model;
    }
}