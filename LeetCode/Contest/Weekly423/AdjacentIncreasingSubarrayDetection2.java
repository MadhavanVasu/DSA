package LeetCode.Contest.Weekly423;

import java.util.List;

public class AdjacentIncreasingSubarrayDetection2 {

    public boolean isFeasible(List<Integer> nums, int[] increasingCount, int n, int k) {
        for (int i = 0; i <= n - k - k; i++) {
            if (increasingCount[i] >= k && increasingCount[i + k] >= k) return true;
        }
        return false;
    }

    public int maxIncreasingSubarrays(List<Integer> nums) {

        int n = nums.size();
        int[] increasingCount = new int[n];
        int start = 0;
        int count = 1;
        for (int i = 1; i <= n; i++) {
            if (i == n || nums.get(i) <= nums.get(i - 1)) {
                int j = start;
                while (j < i) {
                    increasingCount[j] = count;
                    count--;
                    j++;
                }
                count = 1;
                start = i;
            } else count++;
        }
        start = 1;
        int end = n / 2;
        int result = 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isFeasible(nums, increasingCount, n, mid)) {
                if (mid > result) result = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return result;
    }

    public static void main(String[] args) {
    }

}
