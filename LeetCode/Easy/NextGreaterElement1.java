package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] < stack.peek())
                stack.push(nums2[i]);
            else {
                while (!stack.isEmpty()) {
                    if (stack.peek() < nums2[i]) {
                        int ele = stack.pop();
                        map.put(ele, nums2[i]);
                    } else
                        break;
                }
                stack.push(nums2[i]);
            }
        }
        int[] result = new int[nums1.length];
        int i = 0;
        for (int x : nums1)
            result[i++] = map.getOrDefault(x,-1);
        return result;
    }

    public static void main(String[] args) {

    }

}
