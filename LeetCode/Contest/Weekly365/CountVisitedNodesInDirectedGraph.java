package LeetCode.Contest.Weekly365;

import java.util.List;

public class CountVisitedNodesInDirectedGraph {

    int visitedNode = -1;

    public int dfs(int i, Integer[] visited, List<Integer> edges, int[] result, int count) {
        int neighbor = edges.get(i);
        visited[i] = count;
        if (visited[neighbor] != null) {
            if (result[neighbor] == 0) {
                result[i] = count - visited[i] + 1;
                visitedNode = neighbor;
            } else {
                result[i] = result[neighbor] + 1;
            }
        } else {
            int value = dfs(edges.get(i), visited, edges, result, count + 1);
            if (visitedNode != -1) {
                result[i] = value;
                if (i == visitedNode) visitedNode = -1;
            } else {
                result[i] = value + 1;
            }
        }
        return result[i];
    }

    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        Integer[] visited = new Integer[n];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == null) {
                dfs(i, visited, edges, result, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
