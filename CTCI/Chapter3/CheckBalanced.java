public class CheckBalanced {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
        }
    }
    //Inefficient method
    static int height(Node root) {
        if(root == null) {
            return -1;
        }
        return Math.max(height(root.left),height(root.right)) + 1;
    }
    
    static boolean checkBalanced(Node root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(height(root.left) - height(root.right)) > 1) 
            return false;
        return checkBalanced(root.left) && checkBalanced(root.right);     

    }

    //efficient method
    static int getHeight(Node root) {
        if(root == null) {
            return -1;
        }
        int leftHeight = getHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int rightHeight = getHeight(root.right);
        if(rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int diff = leftHeight - rightHeight;
        if(Math.abs(diff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    static boolean checkBalancedEfficient(Node root) {
        return getHeight(root) != Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(4);

        if(checkBalancedEfficient(root)) {
            System.out.println("balanced");
        } else {
            System.out.println("not balanced");
        }
    }
}