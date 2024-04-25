package LeetCode.Medium;

public class LongestIdeaSubsequence {

    public int longestIdealStringEfficient(String s, int k) {
        int n = s.length();
        int[] dp = new int[26];
        for (int i = n - 1; i >= 0; i--) {
            int val = s.charAt(i) - 'a';
            int max = Integer.MIN_VALUE;
            int left = Math.max(val - k, 0);
            int right = Math.min(val + k, 25);
            for (int j = left; j <= right; j++) {
                max = Math.max(max, dp[j]);
            }
            dp[val] = max + 1;
        }
        int result = 0;
        for (int val : dp) {
            result = Math.max(result, val);
        }
        return result;
    }

    public int helper(int i, int j, String s, int n, Integer[][] dp, int k) {
        if (i == n) return 0;
        if (j != -1 && dp[i][j] != null) return dp[i][j];
        if (j == -1 && dp[i][26] != null) return dp[i][26];
        int a = 0;
        if (j == -1 || Math.abs(j - (s.charAt(i) - 'a')) <= k) {
            a = 1 + helper(i + 1, s.charAt(i) - 'a', s, n, dp, k);
        }
        int b = helper(i + 1, j, s, n, dp, k);
        if (j == -1) j = 26;
        dp[i][j] = Math.max(a, b);
        return dp[i][j];
    }

    public int longestIdealString(String s, int k) {
        int n = s.length();
        Integer[][] dp = new Integer[n][27];
        return helper(0, -1, s, n, dp, k);
    }

    public static void main(String[] args) {

    }
}
