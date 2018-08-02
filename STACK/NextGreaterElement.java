import java.util.*;

class NextGreaterElement {
    static void nextGreater(int arr[])  {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(arr[0]);
        for(int i=1;i<arr.length;i++) {
            if(!stack.isEmpty()) {
                while(!stack.isEmpty() && arr[i] > stack.peek()) {
                    System.out.println(stack.pop() +  " --> " + arr[i]);
                }
            }
            stack.push(arr[i]);
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pop() +  " --> -1");
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[]{11,13,21,3};
        nextGreater(arr);
    }
}
