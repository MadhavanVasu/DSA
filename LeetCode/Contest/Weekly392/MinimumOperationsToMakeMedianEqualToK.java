package LeetCode.Contest.Weekly392;

import java.util.Arrays;

public class MinimumOperationsToMakeMedianEqualToK {

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        long result = 0;
        int n = nums.length;
        result += Math.abs(k - nums[n / 2 + 1]);
        nums[n / 2] = k;
        int i = n / 2 - 1;
        while (i >= 0 && nums[i] > nums[i + 1]) {
            result += Math.abs(nums[i] - nums[i + 1]);
            nums[i] = nums[i + 1];
            i--;
        }
        i = n / 2 + 1;
        while (i < n && nums[i] < nums[i - 1]) {
            result += Math.abs(nums[i] - nums[i - 1]);
            nums[i] = nums[i - 1];
            i++;
        }
        return result;
    }


    public static void main(String[] args) {

    }

}
