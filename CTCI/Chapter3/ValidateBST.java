import java.util.*;
public class ValidateBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
        }
    }
//Definition of BST:
// A binary tree where the left subtree of a node contains keys lesser than or equal
// to the nodes key and the right subtree of the node contains keys greater than
// the nodes key.
// The left and right subtrees are also BSTs.

//DOES NOT WORK!!!
//This checks only immediate children and not the entire subtree for BST property.
    // static boolean isBST(Node root) {
    //     if(root == null) {
    //         return true;
    //     }
    //     if(root.left != null) {
    //         if(root.data < root.left.data) {
    //             return false;
    //         }
    //     }
    //     if(root.right != null) {
    //         if(root.data >= root.right.data) {
    //             return false;
    //         }
    //     }
    //     return isBST(root.left) && isBST(root.right);
    // }

    static Integer last;
    static boolean isBST(Node root) {
        if(root == null) {
            return true;
        }
        if(!isBST(root.left)) {
            return false;
        }

        if(last != null && root.data <= last) {
            return false;
        }
        last = root.data;
        
        if(!isBST(root.right)) {
            return false;
        }

        return true;
    }


    //alternate method
    static boolean checkBST(Node root) {
        return checkBST(root,null,null);
    }

    static boolean checkBST(Node root,Integer min,Integer max) {
        if(root == null) {
            return true;
        }

        if((min != null && root.data <= min) || (max != null && root.data > max)) {
            return false;
        }

        return checkBST(root.left,min,root.data) && checkBST(root.right,root.data,max);
    }
    public static void main(String args[]) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.left.right = new Node(4);
        root.right = new Node(5);
        if(checkBST(root)) {
            System.out.print("BST");
        } else {
            System.out.print("NOT BST");
        }
    }
}