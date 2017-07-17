package com.yishuailuo.mywebproject.controller;

import com.yishuailuo.mywebproject.service.HelloWorldService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by luoyishuai on 17/7/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration 指定加载的 spring 配置文件（一个或多个）的位置, locations=xml配置文件， classes=class配置文件
@ContextConfiguration(locations = "classpath:applicationContext-unitTest.xml")
@WebAppConfiguration
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
