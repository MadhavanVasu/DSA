package LeetCode.Easy;

import java.util.Stack;

public class ValidParantheses {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(')
                stack.add(s.charAt(i));
            if(stack.isEmpty())
                return false;
            else if (s.charAt(i) == '}' && stack.peek() == '{')
                stack.pop();
            else if (s.charAt(i) == ']' && stack.peek() == '[')
                stack.pop();
            else if (s.charAt(i) == ')' && stack.peek() == '(')
                stack.pop();
            else
                return false;
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

        String s = "{{[[]}}";
        System.out.println(isValid(s));

    }

}
