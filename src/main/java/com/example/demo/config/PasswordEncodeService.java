package com.example.demo.config;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * パスワードをハッシュ化してDBに保持できる状態にする
 * サービスクラス
 */
@Service
@Transactional
public class PasswordEncodeService {

    @Autowired
    UserAccountRepository repository;
    @Autowired
    PasswordEncoder encoder;

    /**
     * 
     * @param account
     * @return ハッシュ化されたパスワードを保持したUserAccount
     */
    public UserAccount CreateHashPassword(UserAccount account) {
        String encodedPassword = encoder.encode(account.getPassword());
        account.setPassword(encodedPassword);
        return repository.save(account);
    }
}