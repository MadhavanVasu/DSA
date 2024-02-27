package LeetCode.Medium;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || temperatures[stack.peek()] > temperatures[i]) stack.push(i);
            else {
                while (!stack.isEmpty()) {
                    if (temperatures[stack.peek()] < temperatures[i]) {
                        int j = stack.pop();
                        result[j] = j - i;
                    } else break;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
