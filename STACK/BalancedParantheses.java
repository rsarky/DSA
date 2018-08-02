import java.util.*;

class BalancedParantheses {
    static boolean checkBalanced(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : input.toCharArray()) {
            if( c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(c == ')' || c == '}' || c=='[') {
                    if(stack.isEmpty()) {
                        return false;
                    }
                    if( c == ')' && stack.peek() != '(' ||
                        c == '}' && stack.peek() != '{' ||
                        c == ']' && stack.peek() != '[') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(checkBalanced(sc.next()));
    }
}