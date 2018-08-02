
class Intersection {
    static class Node {
        int data;
        Node next = null;
        Node(int data) {
            this.data = data;
        }
    }
    static Node findIntersection(Node head1,Node head2) {
        Node tail1 = head1;
        Node tail2 = head2;
        while(tail1.next != null)
            tail1 = tail1.next;
        while(tail2.next != null)
            tail2 = tail2.next;
        if(tail1 != tail2) return null;

        int l1 = findLength(head1);
        int l2 = findLength(head2);
        if(l1 > l2) {
            for(int i=0;i<l1-l2;i++) {
                head1 = head1.next;
            }
        } else {
            for(int i=0;i<l2-l1;i++) {
                head2 = head2.next;
            }
        }

        while(true) {
            if(head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
    }

    static int findLength(Node n) {
        if(n==null){
            return 0;
        }
        return 1 + findLength(n.next);
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(3);
        
        Node list2 = new Node(4);
        list2.next = list1.next;

        System.out.println(findIntersection(list1, list2).data);
    }
}