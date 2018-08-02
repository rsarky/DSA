import java.util.Deque;
import java.util.Scanner;

public class BinaryTree{
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    static TreeNode createTree(int d) {
        Scanner sc  = new Scanner(System.in);

        if(d != -1) {
            TreeNode t = new TreeNode(d);
            System.out.println("Enter left child of " + d + " :");
            t.left = createTree(sc.nextInt());
            System.out.println("Enter right child of " + d + " :");
            t.right = createTree(sc.nextInt());
            return t;
        }  else {
            return null;
        }
    }

    //Traversals using recursion
    static void inorder(TreeNode root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    static void preorder(TreeNode root) {
        if(root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void postorder(TreeNode root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    //Traversals without recursion

    static void inorderIterative(TreeNode root) {
        if(root == null) {
            return;
        }
        Deque<Integer> stack = new ArrayDeque<Integer>();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root of the tree:");

        TreeNode root = createTree(sc.nextInt());

        inorder(root);
        System.out.println("");
        preorder(root);
        System.out.println("");
        postorder(root);
    }


}