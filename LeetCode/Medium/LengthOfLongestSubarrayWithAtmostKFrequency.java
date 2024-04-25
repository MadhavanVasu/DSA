package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubarrayWithAtmostKFrequency {

    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int start = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
            if (freqMap.get(nums[i]) > k) {
                int len = i - start;
                result = Math.max(len, result);
                while (nums[start] == nums[i]) {
                    freqMap.put(nums[start], freqMap.get(nums[start]) - 1);
                    start++;
                }
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
