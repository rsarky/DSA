
class Palindrome{
    static class Node {
        int data;
        Node next;
        Node(int x) {
            data = x;
        }
    }
   
    //Solution 1 : Reverse and compare.
    static boolean isPalindrome(Node head) {
        Node rev = reverseAndCopy(head);
        return isEqual(rev,head);
    }

    static Node reverseAndCopy(Node head) {
        Node n;
        Node newhead = null;
        while(head != null) {
            n = new Node(head.data);
            n.next = newhead;
            newhead = n;
            head = head.next;            
        }
        return newhead; 
    }

    static boolean isEqual(Node a, Node b) {
        while(a!=null && b!=null) {
            if(a.data != b.data) return false;
            a = a.next;
            b = b.next;
        }
        return true;
    }

    //Solution 2 : Using a stack.
    //Todo



    //Solution 3: Recursive
    static class Result {
        Node n; 
        boolean result;
        Result(Node x,boolean b) {
            n = x;
            result = b;
        }
    }
    static boolean isPalindromeRecursive(Node head) {
        int l = findLength(head);
        Result res = recurser(head,l);
        return res.result;
    }

    static Result recurser(Node head, int length) {
        if(head==null || length == 0) {
            return new Result(head,true);
        } else if (length == 1) {
            return new Result(head.next,true);
        }

        Result res = recurser(head.next, length - 2);
        if(!res.result || head==null) {
            return res;
        }

        res.result = ((head.data) == (res.n).data);
        res.n = res.n.next;
        return res;
    }

    static int findLength(Node n) {
        if(n==null){
            return 0;
        }
        return 1 + findLength(n.next);
    }
    static void print(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String args[]) {
        Node h = new Node(1);
        h.next = new Node(2);
        h.next.next = new Node(3);
        h.next.next.next = new Node(2);
        h.next.next.next.next = new Node(1);
        
        System.out.println(isPalindromeRecursive(h));
    }
}