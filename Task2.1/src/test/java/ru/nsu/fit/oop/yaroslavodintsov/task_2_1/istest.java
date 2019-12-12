package ru.nsu.fit.oop.yaroslavodintsov.task_2_1;


import org.junit.Assert;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class istest {
    @Test
    public void testcase0() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1234);
        stack.push(12345);
        stack.push(12);
        stack.push(1);
        stack.push(0);
        stack.push(-12);
        stack.push(1234);
        stack.push(12345);
        stack.push(12);
        stack.push(1);
        stack.push(0);
        stack.push(-12);
        stack.push(1234);
        stack.push(12345);
        stack.push(12);
        stack.push(1);
        stack.push(0);
        stack.push(-12);

        assertThat(stack.pop(), is(-12));
        assertThat(stack.pop(), is(0));
        assertThat(stack.pop(), is(1));
        assertThat(stack.pop(), is(12));
        assertThat(stack.pop(), is(12345));
        assertThat(stack.pop(), is(1234));
        assertThat(stack.pop(), is(-12));
        assertThat(stack.pop(), is(0));
        assertThat(stack.pop(), is(1));
        assertThat(stack.pop(), is(12));
        assertThat(stack.pop(), is(12345));
        assertThat(stack.pop(), is(1234));
        assertThat(stack.pop(), is(-12));
        assertThat(stack.pop(), is(0));
        assertThat(stack.pop(), is(1));
        assertThat(stack.pop(), is(12));
        assertThat(stack.pop(), is(12345));
        assertThat(stack.pop(), is(1234));

    }

    
    @Test(expected = NoSuchElementException.class)
    public void testcase1() {
        Stack<String> stack = new Stack<>();

        stack.pop();
    }


    @Test
    public void testcase2() {
        Stack<String> stack = new Stack<>();

        stack.push("HI");
        stack.push("I");
        stack.push("AM");
        stack.push("TIRED");
        stack.push("AFTER");
        stack.push("100");
        stack.push("HOURS");
        stack.push("OF");
        stack.push("JAVA");
        stack.push("CODING");


        assertThat(stack.pop(), is("CODING"));
        assertThat(stack.pop(), is("JAVA"));
        assertThat(stack.pop(), is("OF"));
        assertThat(stack.pop(), is("HOURS"));
        assertThat(stack.pop(), is("100"));
        assertThat(stack.pop(), is("AFTER"));
        assertThat(stack.pop(), is("TIRED"));
        assertThat(stack.pop(), is("AM"));
        assertThat(stack.pop(), is("I"));
        assertThat(stack.pop(), is("HI"));
    }


    @Test
    public void testcase3() {
        Stack<Boolean> stack = new Stack<>();

        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);


        assertThat(stack.pop(), is(false));
        assertThat(stack.pop(), is(false));
        assertThat(stack.pop(), is(false));
        assertThat(stack.pop(), is(true));
    }


    @Test
    public void testcase4() {
        Stack<Boolean> stack = new Stack<>();


        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);
        stack.push(true);
        stack.push(false);
        stack.push(false);
        stack.push(false);


        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        Assert.assertTrue(stack.size() == 196);

    }
}