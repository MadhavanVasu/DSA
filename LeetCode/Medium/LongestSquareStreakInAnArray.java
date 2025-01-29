package LeetCode.Medium;

import java.util.*;

public class LongestSquareStreakInAnArray {
//
//    public int longestSquareStreakWithoutDp(int[] nums)
//    {
//        Arrays.sort(nums);
//        Set<Integer> set = new HashSet<>();
//        for(int x : nums) set.add(x);
//        for(int )
//    }

    public int helper(int i, int[] nums, int n, Integer[] dp, Map<Long, Integer> numMap) {
        if (i == n) return 0;
        if (dp[i] != null) return dp[i];
        int a = 1;
        if (numMap.containsKey(((long) nums[i]) * nums[i])) {
            a += helper(numMap.get((long) nums[i] * nums[i]), nums, n, dp, numMap);
        }
        dp[i] = a;
        return dp[i];
    }

    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Map<Long, Integer> numMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!numMap.containsKey(nums[i]))
                numMap.put((long) nums[i], i);
        }
        Integer[] dp = new Integer[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] == null) {
                int result = helper(i, nums, n, dp, numMap);
                if (result > 1) max = Math.max(max, result);
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
