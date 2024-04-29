package LeetCode.Contest.Weekly395;

import java.util.Arrays;

public class FindTheIntegerAddedToArray2 {

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] diffArr = new int[]{nums2[0] - nums1[0], nums2[0] - nums1[1], nums2[0] - nums1[2]};
        int ans = Integer.MAX_VALUE;
        for (int diff : diffArr) {
            int i = 0;
            int j = 0;
            int miss = 0;
            while (j < nums2.length && miss <= 2) {
                if (nums2[j] - nums1[i] == diff) {
                    i++;
                    j++;
                } else {
                    miss++;
                    i++;
                }
            }
            if (miss <= 2) {
                ans = Math.min(ans, diff);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
