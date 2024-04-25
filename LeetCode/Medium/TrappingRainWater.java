package LeetCode.Medium;

import java.util.Stack;

public class TrappingRainWater {

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            if ((stack.isEmpty() && height[i] != 0)
                    || (!stack.isEmpty() && height[i] <= height[stack.peek()])) {
                stack.push(i);
            } else if (!stack.isEmpty() && (height[i] > height[stack.peek()] && stack.size() == 1)) {
                stack.pop();
                stack.push(i);
            } else if (!stack.isEmpty() && (height[i] > height[stack.peek()] && stack.size() > 1)) {
                int lastInd = -1;
                int prev = i;
                while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                    int ind = stack.pop();
                    lastInd = ind;
                    if (prev - ind > 1)
                        result += ((i - ind) * Math.abs(height[i] - height[ind]));
                    else
                        result += Math.abs(height[i] - height[ind]);
                    prev = ind;
                }
                if (stack.isEmpty()) {
                    int count = i - lastInd;
                    result -= (count * (Math.abs(height[i] - height[lastInd])));
                    stack.push(i);
                } else {
                    height[lastInd] = height[i];
                    stack.push(lastInd);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] nums = new int[]{4, 2, 1, 3};
        System.out.println(new TrappingRainWater().trap(nums));

    }
//    4 2 1 3

}
