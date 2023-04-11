package LeetCode.Contest.Biweekly101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestCycleInAGraph {

    int min = Integer.MAX_VALUE;

    public void dfs(int i, int parent, int length, int[] visited, List<List<Integer>> adjList) {
        visited[i] = length;
        for (int x : adjList.get(i)) {
            if (visited[x] != -1) {
                if (x != parent) {
                    int dist = length + 1;
                    if (dist < min && dist>1)
                        min = dist;
                    length = 0;
                }
            } else
                dfs(x, i, length + 1, visited, adjList);
        }
    }

    public int findShortestCycle(int n, int[][] edges) {

        int[] visited = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) visited[i] = -1;
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1){
                dfs(i, -1, 0, visited, adjList);
            }
        }
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {3, 4}, {4, 5}, {5, 6}, {6, 3}};
        ShortestCycleInAGraph obj = new ShortestCycleInAGraph();
        System.out.println(obj.findShortestCycle(n, edges));

    }


}
