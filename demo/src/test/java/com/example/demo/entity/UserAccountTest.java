package com.example.demo.entity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

/**
 * UserAccountのバリデーション機能のテストクラス
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserAccountTest {

    @Autowired
    Validator validator;

    private UserAccount account = new UserAccount();
    private BindingResult result = new BindException(account, "UserAccount");

    @BeforeEach
    public void init() {
        account.setUserName("TEST");
        account.setPassword("test1234");
    }

    @Test
    public void TestUserNameIsDefault() {
        validator.validate(account, result);
        assertThat(account.getUserName()).isNotNull();
    }

    @Test
    public void TestUserNameIsNull() {
        account.setUserName(null);
        validator.validate(account, result);
        assertThat(result.getFieldError().getField()).isEqualTo("userName");
        assertThat(result.getFieldError().getDefaultMessage()).isEqualTo("名前を入力してください");
    }
    
    @Test
    public void TestUserNameIsEmpty() {
        account.setUserName(" ");
        validator.validate(account, result);
        assertThat(result.getFieldError().getField()).isEqualTo("userName");
        assertThat(result.getFieldError().getDefaultMessage()).isEqualTo("名前を入力してください");
    }
}