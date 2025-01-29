package LeetCode.Contest.Biweekly145;

import java.util.Arrays;

public class MinimumOperationsToMakeArrayEqualToK {

    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = 0;
        boolean foundKEqualElement = false;
        for (int j = n - 1; j >= 0; j--) {
            if (nums[j] < k) return -1;
            if (j != n - 1) {
                if (nums[j] != nums[j + 1]) result++;
            }
            if (nums[j] == k) foundKEqualElement = true;
            if (j == 0 && !foundKEqualElement) result += 1;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
