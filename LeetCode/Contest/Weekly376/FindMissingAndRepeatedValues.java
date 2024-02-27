package LeetCode.Contest.Weekly376;

import java.util.HashSet;
import java.util.Set;

public class FindMissingAndRepeatedValues {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int a = 0;
        int b = 0;
        Set<Integer> set = new HashSet<>();
        int n = grid.length;
        for (int[] row : grid) {
            for (int i = 0; i < n; i++) {
                if (!set.contains(row[i]))
                    set.add(row[i]);
                else a = row[i];
            }
        }
        for (int i = 1; i <= n * n; i++) {
            if (!set.contains(i)) b = i;
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {

    }

}
