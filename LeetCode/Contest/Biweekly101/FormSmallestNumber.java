package LeetCode.Contest.Biweekly101;

import java.util.Arrays;

public class FormSmallestNumber {

    public static int minNumber(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int min1 = nums1[0];
        int min2 = nums2[0];
        int common = -1;
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;
        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                common = nums1[i];
                break;
            } else if (nums1[i] > nums2[j])
                j++;
            else
                i++;
        }
        int res1 = min1 < min2 ? Integer.parseInt(String.valueOf(min1) + String.valueOf(min2)) : Integer.parseInt(String.valueOf(min2) + String.valueOf(min1));
        return common == -1 ? res1 : common;
    }

    public static void main(String[] args) {

        int[] nums1 = {3,5,2,6};
        int[] nums2 = {3,1,7};
        System.out.println(minNumber(nums1,nums2));

    }

}
