package org.nightschool;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SanityTest {
    @Test
    public void should_one_plus_two_equal_three() throws Exception {
        //准备数据
        int one = 1;
        int two = 2;

        //执行方法
        int actual = one + two;

        //验证结果
        assertThat(actual, is(3));
    }
}
