import java.util.ArrayDeque;
import java.util.Scanner;

public class MinimalTree {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }

    static Node createMinimalTree(int arr[],int l,int r) {
        int mid = (l+r)/2;
        Node root = new Node(arr[mid]);
        if(l > r) {
            return null;
        } else if(l == r) {
            return root;
        }
        root.left = createMinimalTree(arr, l, mid-1);
        root.right = createMinimalTree(arr, mid+1,r);
        return root;
    }

    static void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    static void levelOrder(Node root) {
        if(root == null) {
            return;
        }
        ArrayDeque<Node> q = new ArrayDeque<MinimalTree.Node>();
        q.add(root);
        while(!q.isEmpty()) {
            Node temp = q.remove();
            System.out.print(temp.data + " ");
            if(temp.left != null) {
                q.add(temp.left);
            }
            if(temp.right != null) {
                q.add(temp.right);
            }
        }
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        Node root = createMinimalTree(arr, 0, arr.length-1);
        levelOrder(root);
    }
}