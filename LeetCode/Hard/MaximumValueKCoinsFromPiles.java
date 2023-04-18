package LeetCode.Hard;

import java.util.ArrayList;
import java.util.List;

public class MaximumValueKCoinsFromPiles {

    public int helper(int i, List<List<Integer>> piles, List<List<Integer>> prefixSum, int k, int n, int[][] dp) {
        if (k == 0 || i >= n) return 0;
        if (dp[i][k] != -1) return dp[i][k];
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < k && j < prefixSum.get(i).size(); j++) {
            int sum = prefixSum.get(i).get(j) + helper(i + 1, piles, prefixSum, k - j - 1, n, dp);
            max = Math.max(max, sum);
        }
        int sum = helper(i + 1, piles, prefixSum, k, n, dp);
        max = Math.max(max, sum);
        dp[i][k] = max;
        return max;
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {

        int n = piles.size();
        List<List<Integer>> prefixSum = new ArrayList<>();
        for (List<Integer> x : piles) {
            int sum = 0;
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < x.size(); i++) {
                sum += x.get(i);
                temp.add(sum);
            }
            prefixSum.add(temp);
        }
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) dp[i][j] = -1;
        }
        return helper(0, piles, prefixSum, k, n, dp);
    }

    public static void main(String[] args) {


    }

}
