package LeetCode.Easy;

import java.util.Stack;

public class MakeTheStringGreat {

    public boolean checkBad(char c1, char c2) {
        return ((c1 >= 65 && c1 <= 90) && (c2 >= 97 && c2 <= 122 && c2 == (97 + (65 - c1))))
                || ((c2 >= 65 && c2 <= 90) && (c1 >= 97 && c1 <= 122 && c2 == (97 + (65 - c1))));
    }

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || !checkBad(stack.peek(), s.charAt(i))) stack.push(s.charAt(i));
            else stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
