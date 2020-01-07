package ru.nsu.fit.oop.yaroslavodintsov.task_5_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;


/**
 * Tester class, launch threads to find composite numbers.
 */
public class Prime {

    private int threadCount;
    private long[] arr;
    private boolean[] res;

    /**
     * @param narr - array to check
     * @param nthreadsCount - threadsCount
     */
    public Prime(long[] narr, int nthreadsCount)
    {
        arr = narr;
        threadCount = nthreadsCount;
        res = new boolean[arr.length];
    }

    /**
     * @return true if there are at least one composite number, false otherwise
     */
    public synchronized boolean runThreads()  {
        boolean[] ans = new boolean[arr.length];
        int blockSize = (arr.length + threadCount - 1) / threadCount;
        ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);
        List<Callable<Boolean>> futureList = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            MultiPrime mp = new  MultiPrime(arr, i * blockSize, (i + 1) * blockSize);
            futureList.add(mp);
        }
        List<Future<Boolean>> listResult = null;
        try {
            listResult = threadPool.invokeAll(futureList);
        }
        catch (InterruptedException e) {
        }
        boolean res = false;
        try {
            for (Future ft : listResult) {
                res |= (boolean) ft.get();
            }
        }
        catch (Exception e) {
            System.out.println("DAMN");
            return false;
        }
        return res;
    }

}