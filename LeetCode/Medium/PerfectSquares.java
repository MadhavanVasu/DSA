package LeetCode.Medium;

public class PerfectSquares {

    public int helper(int i, int sum, int n, int[] perfectSquare, Integer[][] dp, int m) {
        if (i >= m) {
            if (sum != n) return Integer.MAX_VALUE;
            return 0;
        }
        if (sum == n) return 0;
        if (sum > n) return Integer.MAX_VALUE;
        if (dp[i][sum] != null) return dp[i][sum];
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        if (sum + perfectSquare[i] <= n) {
            int temp = helper(i, sum + perfectSquare[i], n, perfectSquare, dp, m);
            if (temp != Integer.MAX_VALUE)
                a = 1 + temp;
            temp = helper(i + 1, sum + perfectSquare[i], n, perfectSquare, dp, m);
            if (temp != Integer.MAX_VALUE)
                b = 1 + temp;
        }
        int c = helper(i + 1, sum, n, perfectSquare, dp, m);
        dp[i][sum] = Math.min(Math.min(a, b), c);
        return dp[i][sum];
    }

    public int numSquares(int n) {
        int sqrt = (int) Math.floor(Math.sqrt(n));
        int[] perfectSquares = new int[sqrt + 1];
        for (int i = 1; i <= sqrt; i++) {
            perfectSquares[i] = i * i;
        }
        Integer[][] dp = new Integer[sqrt + 1][n + 1];
        return helper(1, 0, n, perfectSquares, dp, sqrt + 1);
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
    }
}
