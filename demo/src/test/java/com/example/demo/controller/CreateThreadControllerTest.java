package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

/**
 * CreateThreadControllerのテストクラス
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CreateThreadControllerTest {

    private MockMvc mock;

    @Autowired
    CreateThreadController controller;

    @BeforeEach
    public void setup() {
        mock = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void 引数にNullを持っているか() throws Exception{
        MvcResult result = mock
                            .perform(post("/topic/createThread").param("title","Test"))
                            .andReturn();

        ModelAndView testMav = result.getModelAndView();
        assertNull(testMav);
    }
}