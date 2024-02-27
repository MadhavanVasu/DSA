package LeetCode.Medium;

import java.util.*;

public class MaximumStarSumOfAGraph {

    public int maxStarSum(int[] vals, int[][] edges, int k) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = vals.length;
        int[] visited = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    int sum = vals[v];
                    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
                    for (int x : adjList.get(v)) {
                        pq.add(vals[x]);
                        if (visited[x] != 1) {
                            visited[x] = 1;
                            queue.add(x);
                        }
                    }
                    for (int j = 0; j < k; j++) {
                        if (pq.isEmpty()) break;
                        int val = pq.poll();
                        if (sum + val < sum) break;
                        sum += val;
                    }
                    if (sum > max) max = sum;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }

}
