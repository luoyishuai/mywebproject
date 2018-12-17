package com.yishuailuo.mywebproject.mapper;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.yishuailuo.mywebproject.domain.HelloWorld;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by luoyishuai on 17/7/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration 指定加载的 spring 配置文件（一个或多个）的位置, locations=xml配置文件， classes=class配置文件
@ContextConfiguration(locations = "classpath:applicationContext-integrationTest.xml")
@ActiveProfiles("integration-test")
@WebAppConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class }
)
@DatabaseSetup("classpath:setUpDbSample.xml")
public class ITHelloWorldMapperTest {

    @Autowired
    private HelloWorldMapper helloWorldMapper;


    @Test
    public void test() throws Exception{
        HelloWorld helloWorld = HelloWorld.builder()
                .id(2)
                .name("rose1")
                .nameDesc("rose_desc1")
                .build();
        HelloWorld helloWorldResult = helloWorldMapper.get(helloWorld);
        System.out.println(helloWorldResult);
    }

}
