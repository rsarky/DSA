import java.util.*;

//Stack which performs all normal stack operations in addition to getMin() which
//gets the minimum of all elements in the stack in O(1) time
//Note O(n) extra space is used in this implementation.
class SpecialStack {
    Deque<Integer> stack;
    Deque<Integer> helper;

    SpecialStack() {
        stack = new ArrayDeque<Integer>();
        helper = new ArrayDeque<Integer>();
    }

    void push(int e) {
        stack.push(e);
        if(helper.isEmpty()) {
            helper.push(e);
        } 

        if( e < helper.peek()) {
            helper.push(e);
        }
    }

    int pop() {
        int x = stack.pop();
        if(x == helper.peek()) {
            helper.pop();
        }
        return x;
    }

    int getMin(){
        return helper.peek();
    }

    public static void main(String[] args) {
        SpecialStack s = new SpecialStack();
        s.push(5);
        s.push(4);
        s.push(1);
        s.push(6);
        System.out.println(s.getMin());
        s.pop();
        s.pop();
        System.out.println(s.getMin());
    }
}