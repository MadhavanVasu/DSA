package LeetCode.Medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveToMakeValidParenthesis {

    public String minRemoveToMakeValid(String s) {
        Set<Integer> removeIndices = new HashSet<>();
        Stack<Integer> openParenStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') openParenStack.add(i);
            else if (s.charAt(i) == ')') {
                if (openParenStack.isEmpty()) removeIndices.add(i);
                else openParenStack.pop();
            }
        }
        while (!openParenStack.isEmpty()) removeIndices.add(openParenStack.pop());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!removeIndices.contains(i)) sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
