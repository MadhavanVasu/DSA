package LeetCode.Medium;

public class IntegerBreak {

    public int helper(int n, Integer[] dp) {
        if (n == 1 || n == 0)
            return n;
        if (dp[n] != null) return dp[n];
        int max = 0;
        for (int i = 1; i <= n / 2; i++) {
            int a = helper(n - i, dp);
            int b = helper(i, dp);
            a = Math.max(a, n - i);
            b = Math.max(b, i);
            max = Math.max(max, a * b);
        }
        dp[n] = max;
        return max;
    }

    public int integerBreak(int n) {
        Integer[] dp = new Integer[n + 1];
        return helper(n, dp);
    }

    public static void main(String[] args) {

    }

}
