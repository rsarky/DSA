import java.util.*;

//Queue using single stack.
public class QueueWithStack {
    Deque<Integer> stack;

    QueueWithStack() {
        stack = new ArrayDeque<Integer>();
    }

    void enQueue(int e) {
        stack.push(e);
    }

    int deQueue() {
        if(stack.isEmpty()) { 

        }
        int res = stack.pop();
        if(stack.isEmpty()) {
            return res;
        }
        int ans = deQueue();
        enQueue(res);
        return ans;
    }

    public static void main(String[] args) {
        QueueWithStack q = new QueueWithStack();
        q.enQueue(1);    
        q.enQueue(2);
        q.enQueue(3);
        System.out.println(q.deQueue());
    }
}