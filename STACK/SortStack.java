import java.util.*;

public class SortStack {
    static void insertBottom(Deque<Integer> stack,int x) {
        if(stack.isEmpty()) {
            stack.push(x);
            return;
        } else {
            int a = stack.pop();
            insertBottom(stack, x);
            stack.push(a);
        }
    }

    static void sort(Deque<Integer> stack) {
        if(!stack.isEmpty()) {
            int a = stack.pop();
            sort(stack);
            if(stack.isEmpty()) {
                stack.push(a);
            } else {
                if(a > stack.peek()) {
                    stack.push(a);
                } else {
                    insertBottom(stack, a);
                }
            }
        }
    }
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        sort(stack);

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}