package LeetCode.Contest.Weekly353;

public class LongestNonDecreasingSubarray {

    int max = 0;

    public int helper(int i, int[] nums1, int[] nums2, int[] dp1, int[] dp2, int n, int prev) {
        if (i >= n) return 0;
        if (dp1[i] == -1 || dp2[i] == -1) {
            int a = 1 + helper(i + 1, nums1, nums2, dp1, dp2, n, nums1[i]);
            int b = 1 + helper(i + 1, nums1, nums2, dp1, dp2, n, nums2[i]);
            dp1[i] = a;
            dp2[i] = b;
        }
        int res = 0;
        if (prev < nums1[i] && res < dp1[i]) res = dp1[i];
        if (prev < nums2[i] && res < dp2[i]) res = dp2[i];
        max = Math.max(max, Math.max(dp1[i], dp2[i]));
        return res;
    }

    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for (int i = 0; i < n; i++) {
            dp1[i] = -1;
            dp2[i] = -1;
        }
        helper(0, nums1, nums2, dp1, dp2, n, 0);
        return max;
    }

    public static void main(String[] args) {

    }
}
