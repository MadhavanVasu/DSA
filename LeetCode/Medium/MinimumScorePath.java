package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class MinimumScorePath {

    int min = Integer.MAX_VALUE;

    public int dfs(int i, List<List<List<Integer>>> adjList, int[] visited) {
        visited[i] = 1;
        for (List<Integer> x : adjList.get(i)) {
            if (visited[x.get(0)] != 1)
                dfs(x.get(0), adjList, visited);
            min = min > x.get(1) ? x.get(1) : min;
        }
        return min;
    }

    public int minScore(int n, int[][] roads) {
        List<List<List<Integer>>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) adjList.add(new ArrayList<>());
        for (int[] x : roads) {
            adjList.get(x[0]).add(new ArrayList<>(List.of(x[1], x[2])));
            adjList.get(x[1]).add(new ArrayList<>(List.of(x[0], x[2])));
        }
        int[] visited = new int[n + 1];
        return dfs(1, adjList, visited);
    }

}
