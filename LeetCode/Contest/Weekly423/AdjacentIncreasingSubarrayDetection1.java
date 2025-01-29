package LeetCode.Contest.Weekly423;

import java.util.List;

public class AdjacentIncreasingSubarrayDetection1 {

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {

        int n = nums.size();
        for (int i = 0; i <= n - k - k; i++) {
            boolean isIncreasing = true;
            for (int j = i + 1; j < i + k; j++) {
                if (nums.get(j) <= nums.get(j - 1)) {
                    isIncreasing = false;
                    break;
                }
            }
            for (int j = i + k; j < i + k + k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    isIncreasing = false;
                    break;
                }
            }
            if (isIncreasing) return true;
        }
        return false;
    }


}
