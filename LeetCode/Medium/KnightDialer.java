package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class KnightDialer {

    int MOD = 1000000007;

    public int helper(int i, int n, Integer[][] dp, List<List<Integer>> adjList) {
        if (n == 1) return 1;
        if (dp[i][n] != null) return dp[i][n];
        int result = 0;
        for (int neighbor : adjList.get(i)) {
            result = (result + helper(neighbor, n - 1, dp, adjList)) % MOD;
        }
        dp[i][n] = result;
        return result;
    }

    public int knightDialer(int n) {
        if (n == 1) return 10;
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(new ArrayList<>(List.of(4, 6))); //0
        adjList.add(new ArrayList<>(List.of(6, 8))); //1
        adjList.add(new ArrayList<>(List.of(7, 9))); //2
        adjList.add(new ArrayList<>(List.of(4, 8))); //3
        adjList.add(new ArrayList<>(List.of(0, 3, 9))); //4
        adjList.add(new ArrayList<>()); //5
        adjList.add(new ArrayList<>(List.of(0, 1, 7))); //6
        adjList.add(new ArrayList<>(List.of(2, 6))); //7
        adjList.add(new ArrayList<>(List.of(1, 3))); //8
        adjList.add(new ArrayList<>(List.of(2, 4))); //9

        // DP array
        Integer[][] dp = new Integer[10][n + 1];

        int result = 0;
        for (int i = 0; i <= 9; i++) {
            if (i == 5) continue;
            result = (result + helper(i, n, dp, adjList)) % MOD;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
