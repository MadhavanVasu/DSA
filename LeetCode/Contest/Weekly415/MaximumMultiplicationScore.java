package LeetCode.Contest.Weekly415;

public class MaximumMultiplicationScore {

    public long helper(int i, int j, int[] a, int[] b, Long[][] dp, int n) {
        if (i == 4) return 0;
        if (j == n) return Long.MIN_VALUE;
        if (dp[i][j] != null) return dp[i][j];

        long choose = helper(i + 1, j + 1, a, b, dp, n);
        if (choose != Long.MIN_VALUE) choose += a[i] * b[j];
        long notChoose = helper(i, j + 1, a, b, dp, n);
        dp[i][j] = Math.max(choose, notChoose);
        return dp[i][j];
    }

    public long maxScore(int[] a, int[] b) {
        int n = b.length;
        Long[][] dp = new Long[4][n];
        return helper(0, 0, a, b, dp, n);
    }

}
