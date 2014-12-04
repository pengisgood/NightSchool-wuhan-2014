package org.nightschool.demo;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CalculatorTest {
    @Test
    public void should_one_plus_two_equal_three() throws Exception {
        //Example

        /*
         * This is an unit test for plus method in Calculator class!
         * The 1st part prepares input data, instances to be tested or mock services.
         * The 2nd part executes the method which need to be tested and collects the result.
         * The 3rd part makes an assertion to verify the result.
         * That's it! It looks awesome and quite simple, right?
         */

        //You need to install gradle, then goto '<xxx>/c3-java-tdd-gradle' directory and run 'gradle test' in command line to see the result. If your
        //gradle has been installed properly, you should see 'BUILD SUCCESSFUL' at the last line.

        //准备数据
        Calculator calculator = new Calculator();

        //执行方法
        int result = calculator.plus(1, 2);

        //验证结果
        assertThat(result, is(3));
    }

    @Ignore
    public void should_three_minus_two_equal_one() throws Exception {
        //Help! Trying your best to fix me!
        //After you fix it, replace the @Ignore annotation with @Test annotation and then run 'gradle test' in command line to see the result.

        //准备数据
        Calculator calculator = new Calculator();

        //执行方法
        int result = calculator.minus(3, 2);

        //验证结果
        assertThat(result, is(1));
    }

    @Ignore
    public void should_three_multiply_two_equal_six() throws Exception {
        //Sorry! I have a date with my girlfriend and have to leave now. Please help me finish this test case based on this method name...
        //After you finish it, replace the @Ignore annotation with @Test annotation and then run 'gradle test' in command line to see the result.

        //准备数据


        //执行方法


        //验证结果

    }
}