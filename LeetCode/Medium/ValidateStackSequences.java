package LeetCode.Medium;

import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        int n = pushed.length;
        int m = popped.length;
        if (n != m)
            return false;
        int i = 0;
        while (i < n && j < m) {
            stack.push(pushed[i++]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return i == n && j == m;

    }

    public static void main(String[] args) {

    }

}
