import java.util.Iterator;
import java.util.*;

class DFS {
    int V;
    LinkedList<Integer> adj[];

    DFS(int v) {
        V = v;
        adj = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void dfs(int s) {
        boolean visited[] = new boolean[V];

        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                dfsUtil(s,visited);
            }
        }        
    }

    void dfsUtil(int s, boolean v[]) {
        v[s] = true;
        System.out.print(s + " ");
        Iterator<Integer> iter = adj[s].listIterator();

        while(iter.hasNext()) {
            int n = iter.next();
            if(!v[n]) {
                v[n] = true;
                dfsUtil(n, v);
            }
        }
    }

    public static void main(String args[]) {
        DFS g = new DFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

        g.dfs(2);
    }
}