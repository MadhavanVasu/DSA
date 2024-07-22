package LeetCode.Medium;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParentheses {

    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ')') stack.push(c);
            else {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    char ch = stack.pop();
                    if (ch == '(') break;
                    sb.append(ch);
                }
                for (int i = sb.length() - 1; i >= 0; i--) stack.push(sb.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

    }

}
