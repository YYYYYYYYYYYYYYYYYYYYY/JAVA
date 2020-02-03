package ru.nsu.fit.oop.yaroslavodintsov.task_4_1;

import org.junit.Assert;
import org.junit.Test;

public class istest {

    private Parser calculator = new Parser();
    private String input = "";

    @Test
    public void testcase0() throws Exception {

        input = "+ - 1 2 1";
        double answer = calculator.calculate(input);

        Assert.assertEquals(0, answer, 0);
    }

    @Test
    public void testcase1() throws Exception {

        input = "^ 3 3";
        double answer = calculator.calculate(input);

        Assert.assertEquals(27, answer, 0);
    }

    @Test
    public void testcase1i() throws Exception {

        input = "log 1";
        double answer = calculator.calculate(input);

        Assert.assertEquals(0, answer, 0);
    }

    @Test
    public void testcase1ii() throws Exception {

        input = "sin 0";
        double answer = calculator.calculate(input);

        Assert.assertEquals(0, answer, 0);
    }

    @Test
    public void testcase1iii() throws Exception {

        input = "sqrt 9";
        double answer = calculator.calculate(input);

        Assert.assertEquals(3, answer, 0);
    }

    @Test
    public void testcase1iiii() throws Exception {

        input = "cos 0";
        double answer = calculator.calculate(input);

        Assert.assertEquals(1, answer, 0);
    }

    @Test
    public void testcase1iiiii() throws Exception {

        input = "* 10 0";
        double answer = calculator.calculate(input);

        Assert.assertEquals(0, answer, 0);
    }

    @Test
    public void testcase1iiiiii() throws Exception {

        input = "~ 1";
        double answer = calculator.calculate(input);

        Assert.assertEquals(-1, answer, 0);
    }

    @Test
    public void testcase2() {

        input = "aba 33 33";

        try {
            calculator.calculate(input);
        } catch (Exception e) {
            return; // invalid arg
        }
        Assert.fail();
    }

    @Test
    public void testcase3() {

        input = "sin 2 2";

        try {
            calculator.calculate(input);
        } catch (Exception e) {
            return; // 2many args
        }
        Assert.fail();
    }

    @Test
    public void testcase4() {

        input = "+ 2";

        try {
            calculator.calculate(input);
        } catch (Exception e) {
            return; // 2less args
        }
        Assert.fail();
    }

}
