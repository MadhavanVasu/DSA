package LeetCode.Medium;


public class MinCostTickets {

    public static int helper(int i, int maxDay, int[] days, int[] costs, int[] dp, int n) {
        if (i >= n) return 0;
        if (i != 0 && days[i] <= maxDay)
            return helper(i + 1, maxDay, days, costs, dp, n);
        if (dp[i] != -1)
            return dp[i];
        int a = costs[0] + helper(i + 1, days[i], days, costs, dp, n);
        int b = costs[1] + helper(i + 1, days[i] + 6, days, costs, dp, n);
        int c = costs[2] + helper(i + 1, days[i] + 29, days, costs, dp, n);
        dp[i] = Math.min(Math.min(a, b), c);
        return dp[i];
    }

    public static int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = -1;
        return helper(0, 0, days, costs, dp, n);
    }

    public static void main(String[] args) {
        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs = {2, 7, 15};
        System.out.println(mincostTickets(days, costs));
    }

}
