//Program to recursively reverse a stack.
import java.util.*;

public class ReverseRecursive {
    static void insertAtBottom(Deque<Integer> s, int x) {
        if(s.isEmpty()) {
            s.push(x);
            return;
        } else {
            int a = s.pop();
            insertAtBottom(s, x);
            s.push(a);
        }
    }

    static void reverse(Deque<Integer> stack) {
        if(stack.size() > 0) {
            int a = stack.pop();
            reverse(stack);
            insertAtBottom(stack, a);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        reverse(stack);

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}