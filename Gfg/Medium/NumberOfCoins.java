package Gfg.Medium;

import java.util.Arrays;
import java.util.Collections;

public class NumberOfCoins {

    public static double findMin(int coins[], int i, int V, double dp[][]) {
        if (i >= coins.length) {
            if (V == 0)
                return 0;
            else
                return Double.POSITIVE_INFINITY;
        }
        if (V == 0)
            return 0;
        if (!(dp[i][V] >= Double.POSITIVE_INFINITY)) {
            return dp[i][V];
        }
        double b = findMin(coins, i + 1, V, dp);
        double a = Double.POSITIVE_INFINITY;
        if(coins[i]<=V)
            a = 1 + findMin(coins, i, V-coins[i], dp);
        dp[i][V] = Math.min(a, b);
        return dp[i][V];
    }

    public static int minCoins(int coins[], int M, int V) {
        double[][] dp = new double[M][V + 1];
        for(int i=0; i<M; i++)
        {
            for(int j=0; j<=V; j++)
                dp[i][j] = Double.POSITIVE_INFINITY;
        }

        double res = findMin(coins, 0, V, dp);
        if (res == Double.POSITIVE_INFINITY)
            res = -1;
        return (int) res;
    }

    public static void main(String[] args) {
        int V = 30, M = 3;
        int[] coins = {25,10,5};
        System.out.println(minCoins(coins, M, V));

    }


}
