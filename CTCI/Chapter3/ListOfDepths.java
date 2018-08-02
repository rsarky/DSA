import java.util.*;

public class ListOfDepths {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
        }
    }
//Todo implement dfs version
    static ArrayList<ArrayList<Node>> createLists(Node root, int d) {
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(root);
        for (int i = 0; i < d; i++) {
            ArrayList<Node> l = new ArrayList<>();
            ArrayDeque<Node> tq = new ArrayDeque<>();    
            while (!q.isEmpty()) {
                Node temp = q.remove();
                l.add(temp);
                if (temp.left != null)
                    tq.add(temp.left);
                if (temp.right != null)
                    tq.add(temp.right);
            }
            q = tq;
            list.add(l);
        }
        return list;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        ArrayList<ArrayList<Node>> l = createLists(root, 3);
        for(int i=0;i<l.size();i++) {
            for(int j=0;j<l.get(i).size();j++) {
                System.out.print(l.get(i).get(j).data + " ");
            }
            System.out.println("");
        }
    }
}