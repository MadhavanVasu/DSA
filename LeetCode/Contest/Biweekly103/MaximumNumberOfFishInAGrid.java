package LeetCode.Contest.Biweekly103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumNumberOfFishInAGrid {
    public boolean isValid(int x, int y, int n, int m) {
        if (x >= 0 && x < n && y >= 0 && y < m) return true;
        return false;
    }

    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int max = 0;
        List<List<Integer>> directions = new ArrayList<>();
        directions.add(List.of(0, 1));
        directions.add(List.of(0, -1));
        directions.add(List.of(1, 0));
        directions.add(List.of(-1, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0 && visited[i][j] != true) {
                    Queue<List<Integer>> queue = new LinkedList<>();
                    int fishCaught = 0;
                    queue.add(List.of(i, j));
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        List<Integer> node = queue.poll();
                        int x = node.get(0);
                        int y = node.get(1);
                        fishCaught += grid[x][y];
                        for (List<Integer> direction : directions) {
                            if (isValid(x + direction.get(0), y + direction.get(1), n, m) &&
                                    !visited[x + direction.get(0)][y + direction.get(1)]
                                    && grid[x + direction.get(0)][y + direction.get(1)] != 0) {
                                queue.add(List.of(x + direction.get(0), y + direction.get(1)));
                                visited[x + direction.get(0)][y + direction.get(1)] = true;
                            }
                        }
                    }
                    if (fishCaught > max) max = fishCaught;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
