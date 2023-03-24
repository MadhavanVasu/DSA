package LeetCode.Medium;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement2 {

    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        boolean[] res = new boolean[n];
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(List.of(0, nums[0]));
        for (int i = 1; i < n; i++) {
            if (stack.peek().get(1) > nums[i])
                stack.push(List.of(i, nums[i]));
            else {
                while (!stack.isEmpty()) {
                    if (stack.peek().get(1) < nums[i]) {
                        int ele = stack.pop().get(0);
                        result[ele] = nums[i];
                        res[ele] = true;
                    } else
                        break;
                }
                stack.push(List.of(i, nums[i]));
            }
        }
        int i = 0;
        while (i < n - 1) {
            if (stack.peek().get(1) > nums[i])
                stack.push(List.of(i, nums[i]));
            else {
                while (!stack.isEmpty()) {
                    if (stack.peek().get(1) < nums[i]) {

                        int ele = stack.pop().get(0);
                        if (!res[ele]) {
                            result[ele] = nums[i];
                            res[ele] = true;
                        }
                    } else {
                        break;
                    }
                }
                stack.push(List.of(i, nums[i]));
            }
            i++;
        }
        while (!stack.isEmpty()) {
            int ele = stack.pop().get(0);
            if(res[ele]==false)
                result[ele] = -1;
        }
        return result;

    }

    public static void main(String[] args) {

        int[] nums = {-1,0};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));

    }

}
