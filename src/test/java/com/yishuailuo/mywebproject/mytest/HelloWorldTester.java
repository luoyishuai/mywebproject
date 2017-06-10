package com.yishuailuo.mywebproject.mytest;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by luoyishuai on 17/6/3.
 */
public class HelloWorldTester {

    @Test
    public void testReturnTrue() {
        HelloWorld helloWorld = new HelloWorld();
        assertThat(helloWorld.returnTrue(), is(true));
    }
}
