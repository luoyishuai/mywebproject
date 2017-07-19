package com.yishuailuo.mywebproject.mytest;

import com.yishuailuo.mywebproject.domain.HelloWorld;
import com.yishuailuo.mywebproject.service.HelloWorldService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by luoyishuai on 17/7/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-integrationTest.xml")
public class DemoTest {

    @Autowired
    private HelloWorldService helloWorldService;

    @Test
    public void test() throws Exception{
        HelloWorld helloWorld = HelloWorld.builder().name("jame").nameDesc("jame_desc").build();
        System.out.println(helloWorldService.add(helloWorld));
    }

}
