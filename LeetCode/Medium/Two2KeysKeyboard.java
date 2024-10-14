package LeetCode.Medium;

public class Two2KeysKeyboard {

    public int helper(int i, int clipBoard, int n, Integer[][] dp) {
        if (i > n) return Integer.MAX_VALUE;
        if (i == n) return 0;
        if (dp[i][clipBoard] != null) return dp[i][clipBoard];
        int a = Integer.MAX_VALUE;
        if (clipBoard != 0)
            a = helper(i + clipBoard, clipBoard, n, dp);
        int b = helper(i + i, i, n, dp);
        if (a != Integer.MAX_VALUE) a += 1;
        if (b != Integer.MAX_VALUE) b += 2;

        dp[i][clipBoard] = Math.min(a, b);
        return dp[i][clipBoard];
    }

    public int minSteps(int n) {
        Integer[][] dp = new Integer[n + 1][n + 1];
        return helper(1, 0, n, dp);
    }

}
