package com.example.demo.service;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Response;
import com.example.demo.repository.ResponseRepository;
import com.example.demo.repository.ThreadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * ResponseSave ResponseControllerで受け取ったタイトル名から、ログイン名、作成日を確認して DBに保存するクラス
 */
@Service
public class ResponseSave {
    @Autowired
    ResponseRepository responseRepository;
    @Autowired
    ThreadRepository threadRepository;
    Thread thread;
    UserDetails account;
    Response response;

    public void SaveResponse( Principal principal, Response response, int thread_id) {
        Authentication auth = (Authentication) principal;
        account = (UserDetails) auth.getPrincipal();
        
        //1スレッド目が存在するか、しないかを場合分け
        if (responseRepository.existsByThreadId(thread_id)) {
            //最新のResponseIdより+1大きいIDを付与する
            int max_response = GetLargestResponseId(thread_id);
            max_response += 1;
            response.setResponseId(max_response);
        }
        else {
            response.setResponseId(1);
        }
        response.setId(0);
        response.setThreadId(thread_id);
        response.setAuthor(account.getUsername());
        response.setDate(new Date());
        response.setGoodNum(0);
        response.setText(response.getText());

        responseRepository.save(response);
    }

    public void SaveGoodNum(int id) {
        Response response = responseRepository.findById(id);
        int goodNum = response.getGoodNum();
        goodNum++;
        response.setGoodNum(goodNum);

        responseRepository.save(response);
    }
    
    /**
     * スレッド内で最も大きいResponseIdを取得する
     */
    private int GetLargestResponseId(int thread_id) {
        //スレッド番号が同じレスポンスを取得する
        List<Response> responseList = responseRepository.findAllByThreadId(thread_id);
        int max = responseList.get(0).getId();

        //スレッド内で最新のレスポンスのIDを取得する
        for (Response r : responseList) {
            max = Math.max(max, r.getId());
        }

        //IdよりレスポンスID（表示するID）を検索して返す
        int max_response = responseRepository.findById(max).getResponseId();
        return max_response;
    }
}