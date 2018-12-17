package com.yishuailuo.mywebproject.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.method;

/**
 * Created by luoyishuai on 17/7/28.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(FinalMethodService.class)
public class StaticMethodServiceTest {

    @InjectMocks
    private StaticMethodService staticMethodService;

    @Mock
    private FinalMethodService finalMethodService;

    @Test
    public void testMockStaticMethod() throws Exception{

        String param = "test";

        PowerMockito.mockStatic(StaticMethodService.class);
        Mockito.when(StaticMethodService.staticMethod(param)).thenReturn("hello");

        StaticMethodService spy = spy(staticMethodService);
        when(spy, method(StaticMethodService.class, "privateMethod")).withArguments(param).thenReturn("world");

        String result = staticMethodService.methodCallStaticPrivateMethod("test");
        System.out.println(result);
    }

}
