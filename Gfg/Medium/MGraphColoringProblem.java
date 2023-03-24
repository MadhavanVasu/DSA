package Gfg.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MGraphColoringProblem {

    public static boolean dfs(int v, List<List<Integer>> adjList, Map<Integer, Integer> colors, int m, int[] visited, int[] mainVisited) {
        visited[v] = 1;
        mainVisited[v] = 1;
        for (int i = 1; i <= m; i++) {
            int f = 0;
            colors.put(v, i);
            for (int x : adjList.get(v)) {
                if (visited[x] == 1) {
                    if (colors.get(x) == i) {
                        f = 1;
                        break;
                    }
                } else {
                    boolean res = dfs(x, adjList, colors, m, visited, mainVisited);
                    if (!res) {
                        f = 1;
                        break;
                    }
                }
            }

            if (f == 0) {
                return true;
            }
        }
        visited[v] = 0;
        return false;
    }

    public static boolean graphColoring(boolean graph[][], int m, int n) {

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j])
                    adjList.get(i).add(j);
            }
        }
        Map<Integer, Integer> colors = new HashMap<>();
        int[] mainVisited = new int[n];
        for (int i = 0; i < n; i++) {
            if (mainVisited[i] != 1) {
                int[] visited = new int[n];
                boolean res = dfs(i, adjList, colors, m, visited, mainVisited);
                if (!res)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
