public class ShortestPath {

    /**
     *
     *
     * @param dist array with min distance to the edge = i
     * @param sptSet array for checking the edge = i
     */
    static int minDistance(int dist[], Boolean sptSet[], int N)
    {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 1; v < N; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    /**
     * Function of Dijkstra algorithm
     *
     *
     * @param graph d2 array that store the distance between edge = i and edge = j
     * @param dist array with min distance to the edge = i
     * @param A source edge
     * @param N count of edges
     * @param B destination edge
     * @return distance to the destination edge
     */
    static int dijkstra(int graph[][], int dist[], int A, int N, int B)
    {
        //int dist[] = new int[V];

        Boolean sptSet[] = new Boolean[N];

        for (int i = 1; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }


        dist[A] = 0;


        for (int count = 1; count < N - 1; count++) {

            int u = minDistance(dist, sptSet, N);


            sptSet[u] = true;


            for (int v = 1; v < N; v++)


                if (!sptSet[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        //printSolution(dist, V);
        return dist[B];
    }

    /**
     * Starting point for tests
     * This starting point gets list as input
     *
     * @param list graph stores in list for easier input data editing
     * @param N count of edges
     * @param A source edge
     * @param B destination edge
     * @return distance from the source to the edge
     */
    public static int Solution (int list[][], int N, int A, int B) {



        int graph[][] = new int[N + 1][N + 1];

        for (int i = 0; i < list.length; i++) {
                        graph[list[i][0]][list[i][1]] = list[i][2];
                    }

        int dist[] = new int[N+1];

        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, dist, A, N+1, B);

        int res = dist[B];
        return res;
    }

    /**
     * Starting point
     */
    public static void main(String[] args)
    {

        int V = 9; int src = 0; int dst = 7;

        int dist[] = new int[V];
        int graph[][] = new int[][] {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        //int graph[][];
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, dist, src, V, dst);
        System.out.println(dist[dst]);

    }

}
