package LeetCode.Medium;

import java.util.List;
import java.util.Stack;

public class BeautifulTowers2 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] prefixSum = new long[n];
        long[] suffixSum = new long[n];
        Stack<Integer> stack = new Stack<>();
        long result = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || maxHeights.get(stack.peek()) < maxHeights.get(i)) {
                stack.push(i);
                sum += maxHeights.get(i);
            } else {
                while (!stack.isEmpty()) {
                    if (maxHeights.get(stack.peek()) >= maxHeights.get(i))
                        stack.pop();
                    else break;
                }
                int index = stack.isEmpty() ? -1 : stack.peek();
                sum = stack.isEmpty() ? 0 : prefixSum[stack.peek()];
                sum += ((long) (i - index) * maxHeights.get(i));
                stack.push(i);
            }
            prefixSum[i] = sum;
        }
        stack.clear();
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty() || maxHeights.get(stack.peek()) < maxHeights.get(i)) {
                stack.push(i);
                sum += maxHeights.get(i);
            } else {
                while (!stack.isEmpty()) {
                    if (maxHeights.get(stack.peek()) >= maxHeights.get(i))
                        stack.pop();
                    else break;
                }
                int index = stack.isEmpty() ? n : stack.peek();
                sum = stack.isEmpty() ? 0 : suffixSum[stack.peek()];
                sum += ((long) (index - i) * maxHeights.get(i));
                stack.push(i);
            }
            suffixSum[i] = sum;
            result = Math.max(result, prefixSum[i] + suffixSum[i] - maxHeights.get(i));
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(new BeautifulTowers2().maximumSumOfHeights(List.of(6, 5, 3, 9, 2, 7)));

    }

}
