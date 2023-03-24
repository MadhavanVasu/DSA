package CodingNinjas.Medium;

import java.util.*;

public class MGraphColoringProblem {

    public static boolean isPossible(int v, int color, List<List<Integer>> adjList, Map<Integer, Integer> colorMap) {
        for (int x : adjList.get(v))
            if (colorMap.getOrDefault(x, 0) == color)
                return false;
        return true;
    }

    public static boolean helper(int v, List<List<Integer>> adjList, Map<Integer, Integer> colors, int m, int n) {
        if (v == n)
            return true;
        for (int i = 1; i <= m; i++) {
            colors.put(v, i);
            if (isPossible(v, i, adjList, colors)) {
                boolean res = helper(v + 1, adjList, colors, m, n);
                if (res)
                    return true;
            }
            colors.remove(v);
        }
        return false;
    }

    public static String graphColoring(int[][] mat, int m) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = mat.length;
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1)
                    adjList.get(i).add(j);
            }
        }
        Map<Integer, Integer> colors = new HashMap<>();
        boolean result = helper(0, adjList, colors, m, n);
        if (result)
            return "YES";
        return "NO";
    }

    public static void main(String[] args) {
        int n = 9;
        int m = 2;
//        int[][] mat = {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}};
        int[][] mat = {
                {0, 0, 1, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0, 1, 1, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 0, 0}
        };
//        int[][] mat = {
//                {0,0},
//                {0,0}};
        System.out.println(graphColoring(mat, m));

        double a = 3.000000;
        double b = 2.000000;
        System.out.println((1+1.75)/2);
    }

}
