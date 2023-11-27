package LeetCode.Medium;

import java.util.Arrays;

public class MinimimizeMaximumPairSum {
    public int minPairSumUsingCounting(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : nums) {
            if (x > max) max = x;
            if (x < min) min = x;
        }
        int[] countArr = new int[max + 1];
        for (int x : nums)
            countArr[x]++;
        int i = min;
        int j = max;
        int result = 0;
        while (i <= j) {
            if (countArr[i] != 0 && countArr[j] != 0) {
                int sum = i + j;
                if (sum > result) result = sum;
                countArr[i]--;
                countArr[j]--;
            } else {
                if (countArr[i] == 0) i++;
                if (countArr[j] == 0) j--;
            }
        }
        return result;
    }

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            int pairSum = nums[i] + nums[nums.length - i - 1];
            if (pairSum > max) max = pairSum;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MinimimizeMaximumPairSum().minPairSumUsingCounting(new int[]{3, 5, 2, 3}));
    }

}
