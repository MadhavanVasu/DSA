package LeetCode.Contest.Weekly350;

import java.util.Arrays;

public class FindValueOfThePartition {

    public int findValueOfPartition(int[] nums) {

        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            if (diff < min) min = diff;
        }
        return min;

    }

    public static void main(String[] args) {

    }

}
