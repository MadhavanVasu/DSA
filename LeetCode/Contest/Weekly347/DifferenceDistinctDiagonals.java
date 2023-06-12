package LeetCode.Contest.Weekly347;

import java.util.HashSet;
import java.util.Set;

public class DifferenceDistinctDiagonals {

    public int[][] differenceOfDistinctValues(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] answer = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int topLeft = 0;
                int bottomRight = 0;
                int x = i - 1;
                int y = j - 1;
                Set<Integer> distinct = new HashSet<>();
                while (x >= 0 && y >= 0) {
                    distinct.add(grid[x][y]);
                    x--;
                    y--;
                }
                topLeft += distinct.size();
                distinct.clear();
                x = i + 1;
                y = j + 1;
                while (x < n && y < m) {
                    distinct.add(grid[x][y]);
                    x++;
                    y++;
                }
                bottomRight += distinct.size();
                answer[i][j] = Math.abs(topLeft - bottomRight);
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }

}
