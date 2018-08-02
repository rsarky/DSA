class sumLists extends LinkedList<Integer>{
    // Function to add 2 linked lists when the digits are in reverse order
    //Iterative
    LinkedList<Integer> addReverse(LinkedList<Integer> list) {
        Node arg1 = this.head;
        Node arg2 = list.head;
        LinkedList<Integer> sum = new LinkedList<>();
        int carry = 0;
        while (arg1 != null && arg2 != null) {
            int s = arg1.data + arg2.data + carry;
            carry = s / 10;
            sum.append(s % 10);
            arg1 = arg1.next;
            arg2 = arg2.next;
        }
        while (arg1 != null) {
            int s = arg1.data + carry;
            carry = s / 10;
            sum.append(s % 10);
            arg1 = arg1.next;
        }
        while (arg2 != null) {
            int s = arg2.data + carry;
            carry = s / 10;
            sum.append(s % 10);
            arg2 = arg2.next;
        }
        if(carry > 0) {
            sum.append(carry);
        }
        return sum;
    }

    static int carry = 0;

    LinkedList<Integer> addReverseRecursive(LinkedList<Integer> list) {
        Node arg1 = this.head;
        Node arg2 = list.head;
        LinkedList<Integer> sum = new LinkedList<>();
        sum.head =  addRecursionHelper(arg1,arg2);
        return sum;
    }

    //Add each digit and then recursively pass the carry forward.
    Node addRecursionHelper(Node h1,Node h2) {
        if(h1 == null && h2 == null && carry==0) {
            return null;
        }
        int s = (h1==null? 0:h1.data) + (h2==null? 0:h2.data) + carry;
        Node x = new Node(s%10);
        carry = s/10;        
        x.next = addRecursionHelper(h1==null? null:h1.next, h2==null? null:h2.next);
        return x;

    }

    //Helper class for recursion
    class RecursionHelper {
        Node sum=null;
        int carry = 0;
    }
    //Very Important
    //Recurse till the end. Add digit. Pass carry back
    LinkedList<Integer> addForward(LinkedList<Integer> list) {
        Node l1 = this.head;
        Node l2 = list.head;
        if(this.size < list.size) {
            padZeroes(this,this.size - list.size);
        }
        if(this.size > list.size) {
            padZeroes(list,list.size - this.size);
        }
        
        RecursionHelper sum = new RecursionHelper();
        sum = addForwardRecursionHelper(l1,l2);
        if(sum.carry > 0) {
            sum.sum = insertFront(sum.sum,new Node(sum.carry));
        }

        LinkedList<Integer> ans = new LinkedList<>();
        ans.head = sum.sum;
        return ans;
    }

    RecursionHelper addForwardRecursionHelper(Node l1,Node l2) {
        if(l1==null || l2 == null) {
            return new RecursionHelper();
        }
        RecursionHelper x;
        x = addForwardRecursionHelper(l1.next,l2.next);
        int val = l1.data + l2.data + x.carry;

        x.sum =  insertFront(x.sum, new Node(val%10));
        x.carry = val/10;

        return x;
    }

    void padZeroes(LinkedList<Integer> list,int n) {
        for(int i=0;i<n;i++) {
            list.insertFront(0);
        }
    }

    //Inserts a node to the front of a LL given the head.
    Node insertFront(Node head,Node x) {
        x.next = head;
        return x;
    }

    public static void main(String args[]) {
        sumLists list = new sumLists();
        list.append(9);

        LinkedList<Integer> arg = new LinkedList<>();
        arg.append(6);

        LinkedList<Integer> sum = list.addForward(arg);
        sum.printList();
    }
}