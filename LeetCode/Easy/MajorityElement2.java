package LeetCode.Easy;

// https://leetcode.com/problems/majority-element/description/


import java.util.Arrays;

public class MajorityElement2 {
    public static int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (major == nums[i])
                count++;
            else if (count == 0) {
                major = nums[i];
                count = 1;
            } else
                count--;
        }
        return major;
    }

    // O(n log n) solution
    public static int majorityElement2(int[] nums)
    {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {

        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums));

    }

}
