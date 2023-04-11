package LeetCode.Hard;

import java.util.Arrays;
import java.util.Comparator;

public class ReducingDishes {

    public int maxSatisfactionGreedy(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int prefixSum = 0;
        int result = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            prefixSum += satisfaction[i];
            if (prefixSum < 0) break;
            result += prefixSum;
        }
        return result;
    }

    public static int maxSatisfactionIterative(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        if (satisfaction[n - 1] <= 0)
            return 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int day = 1;
            for (int j = i; j < n; j++) sum += (day++ * satisfaction[j]);
            if (sum > max) max = sum;
        }
        return max;
    }

    public static int helper(int dish, int time, int[] satisfaction, int[][] dp, int n) {
        if (dish >= n)
            return 0;
        if (dp[dish][time] != Integer.MIN_VALUE)
            return dp[dish][time];
        int a = satisfaction[dish] * time + helper(dish + 1, time + 1, satisfaction, dp, n);
        int b = helper(dish + 1, time, satisfaction, dp, n);
        dp[dish][time] = Math.max(a, b);
        return dp[dish][time];
    }

    public static int maxSatisfactionMemoization(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        if (satisfaction[n - 1] <= 0)
            return 0;
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++)
                dp[i][j] = Integer.MIN_VALUE;
        }
        return helper(0, 1, satisfaction, dp, n);

    }

    public static void main(String[] args) {
        int[] satisfaction = {-1, -8, 0, 5, -9};
        System.out.println(maxSatisfactionIterative(satisfaction));
    }

}
