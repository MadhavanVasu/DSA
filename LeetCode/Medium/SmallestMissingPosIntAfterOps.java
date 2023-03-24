package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class SmallestMissingPosIntAfterOps {

    public static int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            if (x < 0) {
                int val = x % value + value;
                map.put(val % value, map.getOrDefault(val % value, 0) + 1);
            } else
                map.put(x % value, map.getOrDefault(x % value, 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            int count = map.getOrDefault(i % value, 0);
            if (count == 0)
                return i;
            map.put(i % value, map.get(i % value) - 1);
        }
        return nums.length;
    }

    public static void main(String[] args) {

//        int[] nums = {3, 2, 3, 1, 0, 1, 4, 2, 3, 1, 4, 1, 3};
//        int value = 5;

        int[] nums = {0, 1, 3, -7};
        int value = 3;

        System.out.println(findSmallestInteger(nums, value));
    }

}
