import java.util.HashSet;

class RemoveDups<T> extends LinkedList<T> {
    //Using hashtable.
    //O(n) complexity
    void removeDuplicates() {
        HashSet<T> hs = new HashSet<>();
        Node i = head;
        Node prev = null;
        while(i != null) {
            if(hs.contains(i.data)) {
                prev.next = i.next;
            }
            else {
                hs.add(i.data);
                prev = i;
            }
            i = i.next;
        }
    }

    //Using constant space.
    //O(n^2) complexity
    void removeDuplicatesSpaceEfficient() {
        Node ptr1 = head;
        while(ptr1 != null) {
            Node ptr2 = ptr1;
            while(ptr2.next != null) {
                if(ptr2.next.data == ptr1.data){
                    ptr2.next = ptr2.next.next;
                } else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }
    public static void main(String args[]) {
        RemoveDups<Integer> rd = new RemoveDups<>();
        rd.append(1);
        rd.append(1);
        rd.append(1);
        rd.append(2);
        rd.append(2);
        rd.append(2);
        rd.removeDuplicatesSpaceEfficient();
        rd.printList();
    }
}