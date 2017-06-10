package com.yishuailuo.mywebproject.mytest;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by luoyishuai on 17/6/3.
 */
public class HamcrestTester {

    @Test
    public void hamcrestTest() {
        Boolean a = true;
        Boolean b = true;

        assertThat(a, equalTo(b));
        assertThat(a, is(b));
    }
}
