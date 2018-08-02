class FirstCommonAncestor {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int x) {
            data = x;
        }
    }

    static Node FCA(Node root,int a, int b) {
        if(covers(root.left,a) && covers(root.left,b)) {
            return FCA(root.left,a,b);
        }
        else if(covers(root.right,a) && covers(root.right,b)) {
            return FCA(root.right,a,b);
        }
        else if(covers(root,a) && covers(root,b)) {
            return root;
        }
        else {
            return null;
        }
    }

    static int flag = 0;
    static boolean covers(Node root,int a) {
        if(root == null) {
            return false;
        }
        if(root.data == a) {
            return true;
        }
        return covers(root.left,a) || covers(root.right,a);
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left = new Node(6);
        root.left.right = new Node(5);
        root.right = new Node(3);
        System.out.println(FCA(root,6,5).data);
    }
}