package com.yishuailuo.mywebproject.controller;

import com.yishuailuo.mywebproject.service.HelloWorldService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by luoyishuai on 17/7/17.
 */

public class HelloWorldControllerStandaloneTest {

    private MockMvc mockMvc;

    @InjectMocks
    private HelloWorldController helloWorldController;

    @Mock
    private HelloWorldService helloWorldService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();
    }

    @Test
    public void test() throws Exception{
        String resultString = "return welcome";
        when(helloWorldService.returnWelcome()).thenReturn(resultString);

        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("return welcome")))
                .andExpect(content().string("return welcome"));
    }

}
