package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSafestPathInTheGird {

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        List<List<Integer>> indices1 = new ArrayList<>();
        List<List<Integer>> indices0 = new ArrayList<>();
        int n = grid.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 0) indices0.add(new ArrayList<>(List.of(i, j)));
                else indices1.add(new ArrayList<>(List.of(i, j)));
            }
        }
        Integer[][] minDistance = new Integer[n][n];
        for (List<Integer> zeroIndex : indices0) {
            int min = Integer.MAX_VALUE;
            for (List<Integer> oneIndex : indices1) {
                int manHattanDistance = Math.abs(zeroIndex.get(0) - oneIndex.get(1));
                if (manHattanDistance < min) min = manHattanDistance;
            }
            minDistance[zeroIndex.get(0)][zeroIndex.get(1)] = min;
        }
        int dist = 0;

        return 0;
    }

    public static void main(String[] args) {

    }

}
