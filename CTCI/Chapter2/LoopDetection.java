
class LoopDetection {
    
    static class Node {
        int data;
        Node next=null;
        Node(int d) {
            data = d;
        }        

        void append(int x) {
            Node newNode = new Node(x);
            Node i = this;
            while (i.next != null) {
               i = i.next; 
            }
            i.next = newNode;
        }
    }

    static Node checkLoop(Node head) {
        Node slowptr = head;
        Node fastptr = head;

        while(fastptr != null) {
            slowptr = slowptr.next;
            fastptr =fastptr.next;
            if(fastptr != null)
                fastptr = fastptr.next;
            else
                return null;
            if(slowptr == fastptr) {
                slowptr = head;
                while(true) {
                    if(slowptr==fastptr) {
                        return slowptr;
                    }
                    slowptr = slowptr.next;
                    fastptr = fastptr.next;
                }
            }
        }
        return null;
    }


    static void print(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }


    public static void main(String[] args) {
        Node list = new Node(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.next.next.next.next.next = list.next.next;
        System.out.println(checkLoop(list).data);
        
    }
}