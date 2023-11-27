package LeetCode.Hard;

public class MaxDotProduct {

    public int helper(int i, int j, int[] nums1, int[] nums2, int n, int m, Integer[][] dp) {
        if (dp[i][j] != null) return dp[i][j];
        int max = Integer.MIN_VALUE;
        int a = nums1[i] * nums2[j];
        if (a > max) max = a;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        int d = Integer.MIN_VALUE;
        if (i + 1 < n && j + 1 < m) {
            int temp = helper(i + 1, j + 1, nums1, nums2, n, m, dp);
            if (a + temp > a) a += temp;
            d = helper(i + 1, j + 1, nums1, nums2, n, m, dp);
        }
        if (j + 1 < m)
            b = helper(i, j + 1, nums1, nums2, n, m, dp);
        if (i + 1 < n)
            c = helper(i + 1, j, nums1, nums2, n, m, dp);
        dp[i][j] = Math.max(Math.max(Math.max(a, b), c), d);
        return dp[i][j];
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Integer[][] dp = new Integer[n][m];
        return helper(0, 0, nums1, nums2, n, m, dp);
    }

    public static void main(String[] args) {

    }

}
