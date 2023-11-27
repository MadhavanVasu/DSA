package LeetCode.Contest.Weekly370;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindChampion2 {

    public int findChampion(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());
        for (int[] x : edges) {
            adjList.get(x[0]).add(x[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            int[] visited = new int[n];
            visited[i] = 1;
            queue.add(i);
            while (!queue.isEmpty()) {
                int vertex = queue.poll();
                for (int x : adjList.get(vertex)) {
                    if (visited[x] != 1) {
                        count++;
                        queue.add(x);
                        visited[x] = 1;
                    }
                }
            }
            if (count == n - 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(new FindChampion2().findChampion(3, new int[][]{{0, 1}, {1, 2}}));
        System.out.println(new FindChampion2().findChampion(4, new int[][]{{0, 2}, {1, 3}, {1, 2}}));
        System.out.println(new FindChampion2().findChampion(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}));

    }

}
