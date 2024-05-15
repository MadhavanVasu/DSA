package LeetCode.Medium;

import java.util.*;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Map<Integer, Integer> edgeCountMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            edgeCountMap.put(i, adjList.get(i).size());
            if (edgeCountMap.get(i) == 1) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            if (n <= 2) return new ArrayList<>(queue);
            while (qSize-- != 0) {
                int node = queue.poll();
                n -= 1;
                for (int adj : adjList.get(node)) {
                    edgeCountMap.put(adj, edgeCountMap.get(adj) - 1);
                    if (edgeCountMap.get(adj) == 1)
                        queue.add(adj);
                }
            }
        }
        return new ArrayList<>(List.of(0));
    }

    public static void main(String[] args) {

    }

}
