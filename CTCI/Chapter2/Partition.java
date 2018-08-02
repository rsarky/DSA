//Trivial implementation would be sorting.
// O(nlogn)
//Therefore need more efficient implementation.
class Partition extends LinkedList<Integer> {

    //Time complexity O(n)
    //Notice how a new list is getting constructed
    void partition(int K) {
        Node h = head; // head pointer
        Node t = head; // tail pointer

        Node i = head;
        while (i != null) {
            Node next = i.next;
            if (i.data < K) {
                i.next = h;
                h = i;
            } else {
                t.next = i;
                t = i;
            }
            i = next;
        }
        t.next = null;
        head = h;
    }

    public static void main(String args[]) {
        Partition test = new Partition();
        test.append(4);
        test.append(3);
        test.append(3);
        test.append(2);
        test.append(1);
        test.partition(2);
        test.printList();
    }
}