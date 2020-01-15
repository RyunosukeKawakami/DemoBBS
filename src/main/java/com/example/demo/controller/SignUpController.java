package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.example.demo.config.PasswordEncodeService;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping(value="/signup")
public class SignUpController {
    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    PasswordEncodeService passwordEncoderService;

    @GetMapping
    public ModelAndView ReturnView(@ModelAttribute("UserAccount") UserAccount account, ModelAndView model){
        model.addObject("UserAccount", account);
        model.setViewName("signup/index.html");
        return model;
    }
    
    @PostMapping
    public ModelAndView SignUp(@ModelAttribute("UserAccount") @Validated UserAccount account, BindingResult result,
            ModelAndView model) {
        
        //入力値に問題がある場合、hasErrorsがTrueとなる。
        if (result.hasErrors()) {
                model.setViewName("signup/index.html");
        }
        else {
            //userNameが存在する場合は登録を行わず、
            //存在することを通知する。
            if (userAccountRepository.existsByUserName(account.getUserName())) {
                model.setViewName("signup/index.html");
                model.addObject("Exist", "true");
            } else {
                //ハッシュ化したパスワードを保持する
                account = passwordEncoderService.CreateHashPassword(account);
                //データベースに保存する。
                userAccountRepository.saveAndFlush(account);
                model.setViewName("index.html");
            }
        }
        return model;
    }
}