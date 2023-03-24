package LeetCode.Medium;

// https://leetcode.com/problems/as-far-from-land-as-possible/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AsFarFromLandasPossible {

    public static boolean validPos(int i, int j, int n) {
        return (i >= 0 && i < n && j >= 0 && j < n);
    }

    // Efficient Solution using BFS - O(N^2)
    public static int maxDistance2(int[][] grid) {

        int n = grid.length;
        int[][] visited = new int[n][n];
        LinkedList<List<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    queue.add(new ArrayList<>(List.of(i, j)));
            }
        }
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int dist = -1;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize-- != 0) {
                List<Integer> vertex = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = vertex.get(0) + directions[i][0];
                    int y = vertex.get(1) + directions[i][1];
                    if (validPos(x, y, n) && grid[x][y] == 0 && visited[x][y] == 0) {
                        visited[x][y] = 1;
                        queue.add(List.of(x, y));
                    }
                }
            }
            dist++;
        }
        return dist == 0 ? -1 : dist;
    }

    // Inefficient Solution - O(n^4)
    public static int maxDistance(int[][] grid) {

        List<List<Integer>> indices1 = new ArrayList<>();
        List<List<Integer>> indices0 = new ArrayList<>();
        int max = -1;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    indices1.add(new ArrayList<>(List.of(i, j)));
                else
                    indices0.add(new ArrayList<>(List.of(i, j)));
            }
        }
        for (List<Integer> x : indices0) {
            int min = -1;
            for (List<Integer> y : indices1) {
                int dist = Math.abs(x.get(0) - y.get(0)) + Math.abs(x.get(1) - y.get(1));
                if (dist < min || min == -1)
                    min = dist;
            }
            if (min > max)
                max = min;
        }
        return max;
    }

    public static void main(String[] args) {

        int[][] grid = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
        System.out.println(maxDistance2(grid));

    }

}
