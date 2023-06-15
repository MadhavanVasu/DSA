package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualRowAndColumnPairs {

    public int equalPairsMap(int[][] grid) {

        int result = 0;
        int n = grid.length;
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                col.add(grid[j][i]);
            }
            map.put(col, map.getOrDefault(col, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            if(map.containsKey(row)) result+=map.get(row);
        }
        return result;
    }

    public int equalPairs(int[][] grid) {

        int result = 0;
        int n = grid.length;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < n; k++) {
                    if (ints[k] != grid[k][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

//        System.out.println(new EqualRowAndColumnPairs().equalPairsMap(null));

    }

}
