package LeetCode.Medium;

import java.util.Arrays;

public class StoneGame2 {

    public Integer[] helper(int i, int M, int player, int[] prefixSum, int n, Integer[][][][] dp) {
        if (i == n) return new Integer[]{0, 0};
        if (dp[i][M][player] != null) return Arrays.copyOf(dp[i][M][player], dp[i][M][player].length);
        int end = Math.min(i + (2 * M), n);
        Integer[] max = new Integer[]{0, 0};
        int diff = Integer.MIN_VALUE;
        int nextPlayer = 1;
        if (player == 1) nextPlayer = 0;
        for (int j = i; j < end; j++) {
            int preSum = i == 0 ? 0 : prefixSum[i - 1];
            int currSum = prefixSum[j] - preSum;
            Integer[] maxPossible = helper(j + 1, Math.max(M, (j - i) + 1), nextPlayer, prefixSum, n, dp);
            int currDiff;
            if (player == 0) {
                maxPossible[0] += currSum;
                currDiff = maxPossible[0] - maxPossible[1];
            } else {
                maxPossible[1] += currSum;
                currDiff = maxPossible[1] - maxPossible[0];
            }
            if (currDiff > diff) {
                diff = currDiff;
                max = Arrays.copyOf(maxPossible, 2);
            }
        }
        dp[i][M][player] = Arrays.copyOf(max, 2);
        return Arrays.copyOf(max, 2);
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        Integer[][][][] dp = new Integer[n][n][2][2];
        int sum = 0;
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            sum += piles[i];
            prefixSum[i] = sum;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) dp[i][j][k] = null;
            }
        }
        Integer[] result = helper(0, 1, 0, prefixSum, n, dp);
        return result[0];
    }

    public static void main(String[] args) {

        int[] piles = new int[]{2, 7, 9, 4, 4};
        System.out.println(new StoneGame2().stoneGameII(piles));

    }

}
