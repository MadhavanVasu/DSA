package LeetCode.Contest.Weekly410;

import java.util.ArrayList;
import java.util.List;

public class CountNumberOfGoodNodes {

    int result = 0;

    public int helper(int node, int parent, List<List<Integer>> adjList) {
        if (adjList.get(node).size() == 1 && node != 0) {
            result++;
            return 1;
        }
        int subtreeSize = 0;
        int totalSize = 1;
        boolean flag = true;
        for (int adj : adjList.get(node)) {
            if (adj != parent) {
                int size = helper(adj, node, adjList);
                if (subtreeSize == 0) subtreeSize = size;
                else if (size != subtreeSize) flag = false;
                totalSize += size;
            }
        }
        if (flag) result++;
        return totalSize;
    }


    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        System.out.println(adjList);
        helper(0, -1, adjList);
        return result;
    }

    public static void main(String[] args) {

//        int[][] edges = new int[][]{{0, 1}, {1, 2}, {1, 3}, {1, 4}, {0, 5}, {5, 6}, {6, 7}, {7, 8}, {0, 9}, {9, 10}, {9, 12}, {10, 11}};
        int[][] edges = new int[][]{{2, 0}, {4, 2}, {1, 2}, {3, 1}, {5, 1}};
        System.out.println(new CountNumberOfGoodNodes().countGoodNodes(edges));

    }


}
