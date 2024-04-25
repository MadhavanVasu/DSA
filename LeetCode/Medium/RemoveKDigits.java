package LeetCode.Medium;

import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            if (stack.isEmpty() || stack.peek() > num.charAt(i)) {
                while (!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                    stack.pop();
                    k--;
                }
            }
            stack.push(num.charAt(i));
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        String s = sb.reverse().toString();
        int start = 0;
        while (start < s.length() && s.charAt(start) == '0') start++;
        if (start == s.length()) return "0";
        return s.substring(start);
    }

    public static void main(String[] args) {

    }

}
