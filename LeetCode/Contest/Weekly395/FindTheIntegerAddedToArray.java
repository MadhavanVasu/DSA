package LeetCode.Contest.Weekly395;

import java.util.Arrays;

public class FindTheIntegerAddedToArray {

    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0] - nums1[0];
    }

    public static void main(String[] args) {

    }

}
