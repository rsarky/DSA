import java.util.*;
//pop costly.
class StackWithQueue {

    Deque<Integer> q1;
    Deque<Integer> q2;

    StackWithQueue() {
        q1 = new ArrayDeque<Integer>();
        q2 = new ArrayDeque<Integer>();
    }

    void push(int e) {
        q1.add(e);
    }

    int pop() {
        while (true) {
            int buffer = q1.remove();
            if (q1.size() == 0) {
                q1 = q2;
                q2.clear();
                return buffer;
            } else {
                q2.add(buffer);
            }
        }

    }

    public static void main(String args[]) {
        StackWithQueue stack = new StackWithQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
    }
}