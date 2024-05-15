package LeetCode.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NoOfOpsMakeGraphConnected {

    public static int makeConnected(int n, int[][] connections) {
        int[] visited = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] x : connections) {
            adjList.get(x[0]).add(x[1]);
            adjList.get(x[1]).add(x[0]);
        }
        Queue<List<Integer>> queue = new LinkedList<>();
        int edges = 0;
        int graphs = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] != 1) {
                graphs += 1;
                queue.add(new ArrayList<>(List.of(i, -1)));
                visited[i] = 1;
                while (!queue.isEmpty()) {
                    List<Integer> ele = queue.poll();
                    int v = ele.get(0);
                    int parent = ele.get(1);
                    for (int x : adjList.get(v)) {
                        if (visited[x] == 1 && x != parent)
                            edges++;
                        else if (visited[x] != 1) {
                            visited[x] = 1;
                            queue.add(new ArrayList<>(List.of(x, v)));
                        }
                    }
                }
            }
        }
        return (edges / 2 < graphs - 1) ? -1 : graphs - 1;
    }

    public static void main(String[] args) {

        int n = 6;
        int[][] connections = {{0, 1}, {0, 2}, {0, 3}, {1, 2}};
        System.out.println(makeConnected(n, connections));
    }

}
