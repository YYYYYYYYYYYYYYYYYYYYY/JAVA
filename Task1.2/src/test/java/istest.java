import org.junit.Assert;
import org.junit.Test;

public class istest {

    @Test
    public void testcase0(){
        int V = 3;
        int src = 2;
        int dst = 1;
        int list[][] = new int[][] {
                {1, 2, 1},
                {1, 3, 1},
                {2, 1, 4},
                {2, 3, 1},
                {3, 1, 2},
                {3, 2, 1}};

        Assert.assertTrue(ShortestPath.Solution(list, V, src, dst) == 3);

    }

    @Test
    public void testcase1(){
        int V = 4;
        int src = 1;
        int dst = 2;
        int list[][] = new int[][] {
                {1, 2, 24},
                {1, 4, 20},
                {3, 1, 3},
                {4, 3, 12}};

        Assert.assertTrue(ShortestPath.Solution(list, V, src, dst) == 24);

    }

    @Test
    public void testcase2(){
        int V = 4;
        int src = 1;
        int dst = 3;
        int list[][] = new int[][] {
                {1, 2, 24},
                {1, 4, 20},
                {3, 1, 3},
                {4, 3, 12}};

        Assert.assertTrue(ShortestPath.Solution(list, V, src, dst) == 32);

    }

    @Test
    public void testcase3(){
        int V = 4;
        int src = 1;
        int dst = 4;
        int list[][] = new int[][] {
                {1, 2, 24},
                {1, 4, 20},
                {3, 1, 3},
                {4, 3, 12}};

        Assert.assertTrue(ShortestPath.Solution(list, V, src, dst) == 20);

    }

    @Test
    public void testcase4(){
        int V = 5;
        int src = 2;
        int dst = 1;
        int list[][] = new int[][] {
                {1, 2, 10},
                {1, 3, 6},
                {2, 4, 8}};

        Assert.assertTrue(ShortestPath.Solution(list, V, src, dst) == Integer.MAX_VALUE);

    }

    @Test
    public void testcase5(){
        int V = 5;
        int src = 2;
        int dst = 4;
        int list[][] = new int[][] {
                {1, 2, 10},
                {1, 3, 6},
                {2, 4, 8}};

        Assert.assertTrue(ShortestPath.Solution(list, V, src, dst) == 8);

    }

    @Test
    public void testcase6() {
        int V = 5;
        int src = 1;
        int dst = 4;
        int list[][] = new int[][]{
                {1, 2, 10},
                {1, 3, 6},
                {2, 4, 8}};

        Assert.assertTrue(ShortestPath.Solution(list, V, src, dst) == 18);

    }

}