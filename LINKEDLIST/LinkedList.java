class LinkedList <T> {
    Node head;

    class Node <T> {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    void append(T data) {
        Node<T> newNode = new Node<T>(data);
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
        Node<T> newNode = new Node<T>(data);
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
        Node previous = null;
        Node current = head;
        while(current != null && !current.data.equals(data)){
            previous = current;
            current = current.next;
        }
        if (current == null) {
            //throw key not found exception
            return;
        }
        previous.next = current.next;
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