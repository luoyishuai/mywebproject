package com.yishuailuo.mywebproject.service;

import com.yishuailuo.mywebproject.domain.HelloWorld;
import com.yishuailuo.mywebproject.mapper.HelloWorldMapper;
import com.yishuailuo.mywebproject.repository.HelloWorldRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

/**
 * Created by luoyishuai on 17/7/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration 指定加载的 spring 配置文件（一个或多个）的位置, locations=xml配置文件， classes=class配置文件
@ContextConfiguration(locations = "classpath:applicationContext-unitTest.xml")
public class HelloWorldServiceTest {

    @InjectMocks
    private HelloWorldService helloWorldService;

    @Mock
    private HelloWorldRepository helloWorldRepository;

    @Mock
    private HelloWorldMapper helloWorldMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() throws Exception {
        when(helloWorldRepository.get()).thenReturn("hello world1");
        String result = helloWorldService.returnWelcome();
        Assert.assertEquals(result, "hello world1");
    }

    @Test
    public void testMapper() throws Exception{
        HelloWorld helloWorld = HelloWorld.builder()
                .id(1)
                .name("rose")
                .nameDesc("roseDesc")
                .build();
        when(helloWorldMapper.get("rose")).thenReturn(helloWorld);
        String result = helloWorldService.getHelloWorldDesc("rose");
        Assert.assertEquals(result, "roseDesc");
    }
}
