package LeetCode.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReorderRoutesToLeadToCityZero {

    public static int minReorder(int n, int[][] connections) {
        List<List<Integer>> outwardEdges = new ArrayList<>();
        List<List<Integer>> inwardEdges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            outwardEdges.add(new ArrayList<>());
            inwardEdges.add(new ArrayList<>());
        }
        for (int[] x : connections) {
            outwardEdges.get(x[0]).add(x[1]);
            inwardEdges.get(x[1]).add(x[0]);
        }
        int[] visited = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int edges = 0;
        visited[0] = 1;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int x : outwardEdges.get(v)) {
                if (visited[x] != 1) {
                    queue.add(x);
                    visited[x] = 1;
                    edges++;
                }
            }
            for (int x : inwardEdges.get(v))
                if (visited[x] != 1) {
                    queue.add(x);
                    visited[x] = 1;
                }
        }
        return edges;
    }

    public static void main(String[] args) {

        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(minReorder(n, connections));

    }

}
