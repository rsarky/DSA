/**** REVERSE A LINKED LIST ****/

//Iterative Solution
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode previous = null;
        ListNode current = head;
        ListNode front;
        
        while (current != null) {
            front = current.next;
            current.next = previous;
            previous = current;
            current = front;
        }
        return previous;
    }
}

//Recursive Solution
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        if (first.next == null) {
            return first;
        }
        ListNode rest = first.next;
        head = reverseList(rest);
        first.next.next = first;
        first.next = null;
        return head;
    }
}