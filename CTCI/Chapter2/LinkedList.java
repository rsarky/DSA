class LinkedList <T> {
    Node head=null;
    int size=0;

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    void append(T data) {
        Node newNode = new Node(data);
        size++;
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
        size++;
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //deletes first occurence.
    void deleteFirstOccurenceOfKey(T data) {
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
                return;
            }
            i = i.next;
        }
    }

    //Deletes all occurences of data
    void deleteAllOccurencesOfKey(T data) {
        if (head == null) {
            //throw exception.
            return;
        }
        if (head.data.equals(data)) {
            head = head.next;
        }
        Node i = head;
        while(i!=null && i.next != null) {
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
        System.out.print('x');
    }

    Node getNode(T x) {
        return new Node(x);
    }
}