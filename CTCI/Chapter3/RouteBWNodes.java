import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
//Logic DFS or BFS through the graph with the given source node and add all nodes encountered
//to a hash table. The hash table thus contains all nodes connected to the given node.
//Check if the destination is contained in the hash table.
//Note that dfs will search through all nodes in a component of a graph.

//If the destination is closer BFS will be more efficient.
//Whereas if the destination is farther DFS will be more efficient.
public class RouteBWNodes {
    static class Graph {
        class Node {
            int data;
            boolean visited;
            Node(int x){
                data = x;
                visited = false;
            }
        }

        int V;
        LinkedList<Node> arrLL[];
        
        Graph(int V) {
            this.V = V;
            arrLL = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                arrLL[i] = new LinkedList<>();
                arrLL[i].add(new Node(i));
            }
        }

        void addEdge(int src, int dest) {
            arrLL[src].add(new Node(dest));
        }
    }




    static void dfs(Graph g,int src, HashSet<Integer> h){
        g.arrLL[src].get(0).visited = true;
        h.add(src);

        for(int i=1;i<g.arrLL[src].size();i++) {
            if(!g.arrLL[src].get(i).visited) {
                dfs(g, g.arrLL[src].get(i).data,h);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(3, 1);
        g.addEdge(3, 2);
        g.addEdge(4, 3);
        HashSet<Integer> hs = new HashSet<>();
        dfs(g, sc.nextInt(), hs);
        System.out.println(hs);
    }
}