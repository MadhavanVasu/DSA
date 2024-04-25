package LeetCode.Medium;

import java.util.Stack;

public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        Stack<Integer> openParenStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') openParenStack.push(i);
            else if (s.charAt(i) == ')') {
                if (!openParenStack.isEmpty()) openParenStack.pop();
                else if (!starStack.isEmpty()) starStack.pop();
                else return false;
            } else starStack.push(i);
        }
        while (!openParenStack.isEmpty() && !starStack.isEmpty()) {
            if (openParenStack.peek() < starStack.peek()) {
                openParenStack.pop();
                starStack.pop();
            } else return false;
        }
        return openParenStack.isEmpty();
    }

//    ((*()))(()))


}
