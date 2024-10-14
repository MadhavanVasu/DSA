package LeetCode.Medium;

public class MinimumDeletionsToMakeStringBalanced {

    public int helper(int i, int flag, String s, int n, Integer[][] dp) {
        if (i == n) return 0;
        if (dp[i][flag] != null) return dp[i][flag];
        int min = Integer.MAX_VALUE;
        if (s.charAt(i) == 'a') {
            if (flag == 0) {
                min = helper(i + 1, 0, s, n, dp);
            } else {
                min = 1 + helper(i + 1, 1, s, n, dp);
            }
        } else {
            if (flag == 0) {
                int a = 1 + helper(i + 1, 0, s, n, dp);
                int b = helper(i + 1, 1, s, n, dp);
                min = Math.min(a, b);
            } else min = helper(i + 1, 1, s, n, dp);
        }
        dp[i][flag] = min;
        return min;
    }

    public int minimumDeletions(String s) {
        return helper(0, 0, s, s.length(), new Integer[s.length()][2]);
    }

    public static void main(String[] args) {

    }

}
