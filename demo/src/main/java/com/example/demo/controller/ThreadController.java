package com.example.demo.controller;

import java.security.Principal;

import com.example.demo.entity.Response;
import com.example.demo.repository.ResponseRepository;
import com.example.demo.service.ResponseSave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ThreadDetails
 */
@RequestMapping(path = "/topic/thread/{id}")
@Controller
public class ThreadController {
    @Autowired
    ResponseRepository repository;
    @Autowired
    ResponseSave save;

    Iterable<Response> response;

    @GetMapping
    public ModelAndView ReturnThreadDetails(@ModelAttribute("Response") Response postResponse, @PathVariable int id, ModelAndView model) {
        response = repository.findAll();
        model.addObject("ResponseList", response);
        model.addObject("Response", postResponse);
        model.addObject("thread_id", id);
        model.setViewName("topic/thread.html");
        return model;
    }

    @PostMapping
    public ModelAndView PostText(@ModelAttribute("Response") @Validated Response postResponse, @PathVariable int id, Principal principal,
        BindingResult result, ModelAndView model) {
        
        if (result.hasErrors()) {
            //getマッピングにリダイレクト
            model.setViewName("redirect:/topic/thread/{id}");
        }
        else {
            save.SaveResponse(principal, postResponse, id);

            response = repository.findAll();
            model.addObject("ResponseList", response);
            model.addObject("Response", postResponse);
            model.addObject("thread_id", id);
            model.setViewName("topic/thread.html");
        }

        return model;
    }

}