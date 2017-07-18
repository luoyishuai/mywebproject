package com.yishuailuo.mywebproject.service;

import com.yishuailuo.mywebproject.domain.HelloWorld;
import com.yishuailuo.mywebproject.mapper.HelloWorldMapper;
import com.yishuailuo.mywebproject.repository.HelloWorldRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

/**
 * Created by luoyishuai on 17/7/17.
 */
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
    public void testMapper() throws Exception {
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
