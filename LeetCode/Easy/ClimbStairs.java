package LeetCode.Easy;

public class ClimbStairs {

    public int helper(int n, int[] dp) {
        if (n == 1 || n == 2) return n;
        if (dp[n] != 0)
            return dp[n];
        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        return dp[n];
    }

    public int climbStairs(int n) {

        int[] dp = new int[n + 1];
        return helper(n, dp);
    }

    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        System.out.println(cs.climbStairs(45));
    }

}
