import java.util.*;

public class Successor {
    static class Node {
        int data;
        Node left;
        Node right;
        Node parent;

        Node(int x) {
            data = x;
        }
    }

    
    Node successor(Node n) {
        if( n == null) {
            return null;
        }

        //If the n has a right child return leftmost node of rightchild
        if(n.right != null) {
            return leftMost(n.right);
        } else {
            Node q = n.parent;
            Node x = n;

            while(q != null && q.left != x) {
                x = q;
                q = q.parent;
            }
            return q;
        }
    }

    Node leftMost(Node x) {
        if(x == null) {
            return null;
        }

        while(x.left != null) {
            x = x.left;
        }
        return x;   
    }
}

