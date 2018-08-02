
//Using adjacency matrix O(V^2) complexity
class Djikstra {
    int V = 9;

    void djikstra(int graph[][],int src) {
        int dist[] = new int[V];
        boolean shortestFound[] = new boolean[V];

        for(int i=0;i<V;i++) {
            dist[i] = Integer.MAX_VALUE;
            shortestFound[i] = false;
        }

        dist[src] = 0;

        for(int i=0;i<V;i++) {
            int u = minDistance(dist,shortestFound);
            shortestFound[u] = true;

            for(int v=0;v<V;v++) {
                if(!shortestFound[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        print(dist);
    }

    int minDistance(int dist[],boolean found[]) {
        int min = Integer.MAX_VALUE, ind = -1;

        for(int i=0;i<dist.length;i++) {
            if(!found[i] && dist[i] < min) {
                min = dist[i];
                ind =  i;
            }
        }
        return ind;
    }

    void print(int arr[]) {
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String args[]) {
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}
                                 };
        Djikstra t = new Djikstra();
        t.djikstra(graph, 0);
    }
}