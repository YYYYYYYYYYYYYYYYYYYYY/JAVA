package ru.nsu.fit.oop.yaroslavodintsov.task_5_1;
import java.util.concurrent.Callable;

/**
 * Thread to check prime number
 */
public class MultiPrime implements Callable<Boolean> {
    private long[] arr;
    private int l, r;
    /**
     * Instantiate prime checker, which checks from left border l to right border r
     * @param narr - array (actually just part)
     * @param nl - left border
     * @param nr - right border
     */
    public MultiPrime(long [] narr, int nl, int nr) {
        arr = narr;
        l = nl;
        r = Math.min(narr.length, nr);
    }

    @Override
    public Boolean call() {
        for (int i = l; i < r; i++) {
            if (arr[i] == 1){
                return true;
            }
            long mval = 0;
            for (long j = 2; j * j <= arr[i]; j++) {
                if (arr[i] % j == 0) {
                    return true;
                }
                mval = j;
            }
        }
        return false;
    }
}