package LeetCode.Medium;

import java.util.Arrays;

public class MaximumLengthOfPairChain {

    public int helper(int i, int j, int n, int[][] pairs, Integer[][] dp) {
        if (i >= n) return 0;
        if (j != -1 && dp[i][j] != null) return dp[i][j];
        if (j == -1 && dp[i][i] != null) return dp[i][i];

        int a = 0;
        if (j == -1 || pairs[i][0] > pairs[j][1])
            a = 1 + helper(i + 1, i, n, pairs, dp);
        int b = helper(i + 1, j, n, pairs, dp);

        if (j == -1) j = i;
        dp[i][j] = Math.max(a, b);
        return dp[i][j];

    }

    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Integer[][] dp = new Integer[n][n];
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] < b[0]) return -1;
            else if (a[0] > b[0]) return 1;
            else if (a[1] < b[1]) return -1;
            else if (a[1] > b[1]) return 1;
            return 0;
        });
        return helper(0, -1, n, pairs, dp);
    }

    public static void main(String[] args) {

    }

}
