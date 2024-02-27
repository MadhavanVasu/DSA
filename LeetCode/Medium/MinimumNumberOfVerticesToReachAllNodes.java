package LeetCode.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumNumberOfVerticesToReachAllNodes {

    public void dfs(int i, List<List<Integer>> adjList, Set<Integer> result, int[] visited) {
        for (int x : adjList.get(i)) {
            if (visited[x] == 0) {
                visited[x] = 1;
                dfs(x, adjList, result, visited);
            } else result.remove(x);
        }
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> result = new HashSet<>();
        int[] visited = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (List<Integer> edge : edges) adjList.get(edge.get(0)).add(edge.get(1));
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                result.add(i);
                dfs(i, adjList, result, visited);
            } else result.remove(i);
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {

    }

}
