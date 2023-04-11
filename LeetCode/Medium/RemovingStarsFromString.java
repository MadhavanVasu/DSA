package LeetCode.Medium;

import java.util.Stack;

public class RemovingStarsFromString {

    public String removeStarsUsingCharArray(String s) {

        char[] charArr = new char[s.length()];
        int top = 0;
        for (char x : s.toCharArray()) {
            if (x == '*')
                top--;
            else
                charArr[++top] = x;
        }
        return new String(charArr, 0, top + 1);


    }

    public String removeStars(String s) {

        StringBuilder sb = new StringBuilder("");
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x == '*') stack.pop();
            else stack.push(x);
        }
        while (!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {

    }

}
