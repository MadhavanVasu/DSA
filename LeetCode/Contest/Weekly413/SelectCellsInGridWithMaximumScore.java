package LeetCode.Contest.Weekly413;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelectCellsInGridWithMaximumScore {

    int max = 0;

    public void helper(int i, Set<Integer> set, List<List<Integer>> grid, int n, int sum) {
        if (i == n) {
            if (sum > max) max = sum;
        } else {
            boolean[] visited = new boolean[101];
            boolean notSelected = true;
            Collections.sort(grid.get(0));
            int prev = 0;
            for (int x : grid.get(i)) {
                if (!set.contains(x) && !visited[x]) {
                    set.add(x);
                    notSelected = false;
                    helper(i + 1, set, grid, n, sum + x);
                    set.remove(x);
                    visited[x] = true;
                }
            }
            if (notSelected)
                helper(i + 1, set, grid, n, sum);
        }
    }

    public int maxScore(List<List<Integer>> grid) {
        helper(0, new HashSet<>(), grid, grid.size(), 0);
        return max;
    }

    public static void main(String[] args) {

    }

}
