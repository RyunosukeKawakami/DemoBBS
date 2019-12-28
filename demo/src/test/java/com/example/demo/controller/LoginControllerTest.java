package com.example.demo.controller;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

import org.assertj.core.api.Assertions;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * DB認証をして、成功したテンプレートを返すかテストする
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LoginControllerTest {

    private MockMvc mock;
    
    @Autowired
    LoginController controller;

    @Before
    public void setup() {
        mock = MockMvcBuilders.standaloneSetup(controller)
            .apply(springSecurity()) 
            .build();
    }

    @Test
    public void PostLoginTest() throws Exception{
        MvcResult result = mock.perform(formLogin("/loginProcess").user("Test_Mikeneko").password("meow")).andReturn();
        Assertions.assertThat(result.getResponse())
                .extracting(MockHttpServletResponse::getStatus, MockHttpServletResponse::getRedirectedUrl)
                .containsExactly(HttpStatus.FOUND.value(), "/login/successful");
    }
    
}