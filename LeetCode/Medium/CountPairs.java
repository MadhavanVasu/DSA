package LeetCode.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountPairs {

    public long countPairs(int n, int[][] edges) {
        long verticesCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] x : edges) {
            adjList.get(x[0]).add(x[1]);
            adjList.get(x[1]).add(x[0]);
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] != 1) {
                queue.add(i);
                visited[i] = 0;
                long tempCount = 0;
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    result += verticesCount;
                    tempCount++;
                    for (int x : adjList.get(v)) {
                        if (visited[x] != 1) {
                            visited[x] = 1;
                            queue.add(x);
                        }
                    }
                }
                verticesCount += tempCount;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
