package LeetCode.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return new ArrayList<>(List.of(0));
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n];
        queue.add(0);
        visited[0] = 1;
        while (!queue.isEmpty()) {
            boolean flag = false;
            Integer node = queue.poll();
            for (int adj : adjList.get(node)) {
                if (adjList.get(adj).size() - 1 == 0) flag = true;
                if (visited[adj] != 1) {
                    visited[adj] = 1;
                    queue.add(adj);
                }
            }
            if (flag) result.add(node);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
