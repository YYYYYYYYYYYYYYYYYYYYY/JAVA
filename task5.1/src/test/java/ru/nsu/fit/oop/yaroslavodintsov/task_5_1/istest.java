package ru.nsu.fit.oop.yaroslavodintsov.task_5_1;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


public class istest {

    @Test
    public void testcase0i(){
        long[] arr = {6,8,7,13,9,4};
        Prime tester = new Prime(arr, 1);
        boolean res = tester.runThreads();
        Assert.assertTrue(res);
    }

    @Test
    public void testcase0ii(){
        long[] arr = {6997901, 6997927, 6997937, 6997967, 6998009, 6998029, 6998039, 6998051, 6998053};
        Prime tester = new Prime(arr, 1);
        boolean res = tester.runThreads();
        Assert.assertFalse(res);
    }

    @Test
    public void testcase0iii(){
        long[] arr = {6997901, 6997927, 6997937, 6997967, 6998009, 6998029, 6998039, 6998051, 6998053, 6998050};
        Prime tester = new Prime(arr, 1);
        boolean res = tester.runThreads();
        Assert.assertTrue(res);
    }


    @Test
    @Ignore
    public void testcase1() {
        long[] arr = {37017414080897969L, 38444570557337449L, 73216126868608051L, 71532764716621001L,
                63349894264261699L, 57972114118217777L, 34533853961825369L}; // big prime arr
        long start = System.currentTimeMillis();
        Prime pt = new Prime(arr, 7);
        boolean res =  pt.runThreads();
        Assert.assertFalse(res);
        System.out.println(res);
        System.out.println(System.currentTimeMillis() - start);
    }


    @Test
    @Ignore
    public void testcase2() {
        long[] arr = {37017414080897969L, 38444570557337449L, 73216126868608051L, 71532764716621001L,
                63349894264261699L, 57972114118217777L, 1000000016000000063L}; //big num arr
        long start = System.currentTimeMillis();
        Prime pt = new Prime(arr, 7);
        boolean res =  pt.runThreads();
        Assert.assertTrue(res);
        System.out.println(res);
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    @Ignore
    public void testcase3() {
        for (int i = 1; i < 8; i++) {
            long[] arr = {37017414080897969L, 38444570557337449L, 73216126868608051L, 71532764716621001L,
                    63349894264261699L, 57972114118217777L, 1000000016000000063L}; //big num arr
            long start = System.currentTimeMillis();
            Prime pt = new Prime(arr, i);
            boolean res = pt.runThreads();
            Assert.assertTrue(res);
            System.out.println(i);
            System.out.println(System.currentTimeMillis() - start);
        }
    }

    /**
     * On my car it is 35 seconds of 1 thread against 17 seconds of 7 threads
     */

}
