import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class InfixToPostfix {
    static boolean isOperand(char a) {
        return a >= 'a' && a <= 'z';
    }

    static int precedence(char a) {
        switch(a) {
            case '-':
            case '+': return 0;
            case '*':
            case '/': return 1;
            case '^': return 2;
            default: return -1;
        }
    }

    static String convert(String infix) {
        StringBuilder ans = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<Character>();

        for(int i=0;i<infix.length();i++) {
            char current = infix.charAt(i);
            if(isOperand(current)) {
                ans.append(current);
            } else if (current == '(') {
                stack.push(current);
            } else if (current == ')') {
                while(stack.peek() != '(') {
                    ans.append(stack.pop());
                }
                stack.pop();
            } else {
                if(stack.isEmpty() || precedence(current) > precedence(stack.peek())) {
                    stack.push(current);
                } else {
                    while(!stack.isEmpty() && precedence(current) <= precedence(stack.peek())) {
                        ans.append(stack.pop());
                    }
                    stack.push(current);
                }
            }
        }
        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return new String(ans);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(convert(input));
    }
}