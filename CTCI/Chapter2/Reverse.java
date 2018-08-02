class Reverse {
    
    static Node reverseIterative(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //Reverse recursive.
    static Node reverseRecursive(Node head) {
        if(head.next == null) {
            return head;
        }
        Node curr = head;
        Node rest = curr.next;
        Node x = reverseRecursive(rest);
        curr.next.next = curr;
        curr.next = null;
        return x;
    }

}