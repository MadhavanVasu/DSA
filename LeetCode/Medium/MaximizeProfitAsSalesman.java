package LeetCode.Medium;

import java.util.Collections;
import java.util.List;

public class MaximizeProfitAsSalesman {

    public int helper(int i, int n, List<List<Integer>> offers, int[] dp) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];
        int notTake = helper(i + 1, n, offers, dp);
        int start = 0;
        int end = n - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (offers.get(mid).get(0) > offers.get(i).get(1)) {
                ans = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        int take = offers.get(i).get(2);
        if (ans != -1)
            take += helper(ans, n, offers, dp);
        dp[i] = Math.max(take, notTake);
        return dp[i];
    }

    public int maximizeTheProfit(int n, List<List<Integer>> offers) {

        Collections.sort(offers, (a, b) -> {
            if (a.get(0) < b.get(0)) return -1;
            else if (a.get(0) > b.get(0)) return 1;
            else {
                if (a.get(1) < b.get(1)) return -1;
                else if (a.get(1) > b.get(1)) return 1;
                else return a.get(2).compareTo(b.get(2));
            }
        });
        int m = offers.size();
        int[] dp = new int[m];
        for (int i = 0; i < m; i++)
            dp[i] = -1;
        return helper(0, m, offers, dp);
    }

    public static void main(String[] args) {

    }

}
