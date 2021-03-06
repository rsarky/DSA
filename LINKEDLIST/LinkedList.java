class LinkedList <T> {
    Node head=null;

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    void append(T data) {
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

    void insertFront(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //Delete first ocurrence of data
    void deleteKey(T data) {
        if (head == null) {
            //throw exception.
            return;
        }
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        Node i = head;
        while(i.next != null) {
            if(i.next.data.equals(data)) {
                i.next = i.next.next;
            }
            i = i.next;
        }
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
}