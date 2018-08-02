public class LeftSideView {
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

    static void printLeftSide(Node root) {
        System.out.print(root.data + " ");
        if(root.left == null && root.right == null) {
            return;
        }
        if(root.left != null)
            printLeftSide(root.left);
        else if(root.right != null)
            printLeftSide(root.right);
    }   

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(5);
        printLeftSide(root);
    }
}