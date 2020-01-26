package com.example.demo.controller;

import java.security.Principal;
import com.example.demo.entity.Response;
import com.example.demo.repository.ResponseRepository;
import com.example.demo.repository.ThreadRepository;
import com.example.demo.service.ResponseSave;
import com.example.demo.entity.Thread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import lombok.extern.slf4j.Slf4j;

/**
 * ThreadDetails
 */
@RequestMapping(path = "/topic/thread/{id}")
@Controller
@Slf4j
public class ThreadController {
    @Autowired
    ResponseRepository repository;
    @Autowired
    ThreadRepository threadRepository;
    @Autowired
    ResponseSave save;

    Iterable<Response> responseList;

    @GetMapping
    public ModelAndView ReturnThreadDetails(@ModelAttribute("Response") Response postResponse, @PathVariable int id,
            ModelAndView model) {
        addObjectThread(model, responseList, postResponse, id);
        return model;
    }

    /**
     * 書き込まれたレスポンスのバリデーション及び、保存をする
     * @param postResponse 書き込まれたレスポンスを受け取る
     * @param result    バリデーションチェック
     * @param id    スレッドのid
     * @param principal ログインユーザの情報
     * @param model
     * @return
     */
    @PostMapping
    public ModelAndView PostText(@ModelAttribute("Response") @Validated Response postResponse, BindingResult result,
            @PathVariable int id, Principal principal, ModelAndView model) {

        if (result.hasErrors()) {
            addObjectThread(model, responseList, postResponse, id);
        } else {
            save.SaveResponse(principal, postResponse, id);
            addObjectThread(model, responseList, postResponse, id);
        }
        return model;
    }

    /**
     * いいねの数を表示及び、保存する
     */
    @PostMapping("/addGoodNum")
    public ModelAndView AddGoodNum(@RequestParam("id") int id, ModelAndView model) {
        log.info("id = {}", id);
        save.SaveGoodNum(id);
        
        model.setViewName("redirect:/topic/thread/{id}");
        return model;
    }

    /**
     * 表示に必要な情報をModelAndViewに詰め込む
     * @param model
     * @param responseList
     * @param postResponse
     * @param thread_id
     * @return
     */
    private ModelAndView addObjectThread(ModelAndView model, Iterable<Response> responseList, Response postResponse,
            int thread_id) {
        responseList = repository.findAllByThreadId(thread_id);
        Thread thread = threadRepository.findById(thread_id);
        String title = thread.getTitle();

        //trueのとき書き込みフォームが表示されるようにする
        if (save.CanWriteResponse(thread_id))
            model.addObject("CanWritable", true);
        else
            model.addObject("CanWritable", false);

        model.addObject("threadTitle", title);
        model.addObject("ResponseList", responseList);
        model.addObject("response", postResponse);
        model.addObject("thread_id", thread_id);
        model.setViewName("topic/thread.html");
        return model;
    }
}