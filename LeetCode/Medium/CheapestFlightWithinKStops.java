package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class CheapestFlightWithinKStops {

    public int dfs(int v, List<List<List<Integer>>> adjList, int[] visited, int dst, int k, int currK, Integer[][] dp) {
        if (currK == k + 1 && v != dst) return Integer.MAX_VALUE;
        if (v == dst) return 0;
        if (dp[v][currK] != null) return dp[v][currK];
        visited[v] = 1;
        int min = Integer.MAX_VALUE;
        for (List<Integer> x : adjList.get(v)) {
            if (visited[x.get(0)] == 0) {
                int a = dfs(x.get(0), adjList, visited, dst, k, currK + 1, dp);
                if (a != Integer.MAX_VALUE && (x.get(1) + a) < min) min = x.get(1) + a;
            }
        }
        dp[v][currK] = min;
        visited[v] = 0;
        return min;
    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<List<Integer>>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] flight : flights)
            adjList.get(flight[0]).add(new ArrayList<>(List.of(flight[1], flight[2])));
        Integer[][] dp = new Integer[n][k + 2];
        int result = dfs(src, adjList, new int[n], dst, k, 0, dp);
        if (result == Integer.MAX_VALUE) return -1;
        return result;
    }

    public static void main(String[] args) {

    }

}
