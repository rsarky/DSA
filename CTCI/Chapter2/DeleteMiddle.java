class DeleteMiddle<T> extends LinkedList<T> {

    void deleteMiddle(Node x) {
        x.data = x.next.data;
        x.next =  x.next.next;

    }


    public static void main(String[] args) {
        DeleteMiddle<Integer> llist =  new DeleteMiddle<>();
        llist.head = llist.getNode(1);
        llist.head.next = llist.getNode(2);
        llist.head.next.next = llist.getNode(3);
        llist.head.next.next.next = llist.getNode(4);
        llist.deleteMiddle(llist.head.next);
        llist.printList();
    }
}