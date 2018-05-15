class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        else {
            Node track = head;
            while (track.next != null)
                track = track.next;
            track.next = newNode;
        }
    }

    void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void printList() {
        if (head == null) 
            return;
        Node track = head;
        while(track != null) {
            System.out.print(track.data + "->");
            track = track.next;
        }
    }

    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.insertFront(1);
        list.insertFront(2);
        list.insertFront(3);
        list.printList();
    }

}