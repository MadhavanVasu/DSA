package LeetCode.Medium;

import java.util.Arrays;

public class RearrangeArrayMaximizePrefix {

    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        int prefix = 0;
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            prefix += nums[i];
            if (prefix <= 0)
                break;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }

}
