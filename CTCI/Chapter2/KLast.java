class KLast<T> extends LinkedList<T> {
    static int counter = 0;
    //Iterative Solution
    //Time complexity: O(n)
    T KthToLast(int K){
       Node ptr1 = head;
       for(int i=0;i<K;i++) {
           if(ptr1 == null) {
               //error
           }
           else {
               ptr1 = ptr1.next;
           }
       }
       Node ptr2 = head;
       while(ptr1.next != null) {
           ptr1 = ptr1.next;
           ptr2 = ptr2.next;
       }
       return ptr2.data;
    }
    
    //Recursive Solution
    T KthToLastRecursive(int K) {
        return recursionHelper(head, K);
    }

    T recursionHelper(Node h, int n) {
        if(h==null) {
            return 0;
        }
        counter = recursionHelper(h.next, n) + 1;
        if (counter == n) {
            return h;
        }

    }
    public static void main(String args[]) {
        KLast<Integer> test = new KLast<>();
        test.append(1);
        test.append(2);
        test.append(3);
        test.append(4);
        System.out.println(test.KthToLast(3));
    }
}