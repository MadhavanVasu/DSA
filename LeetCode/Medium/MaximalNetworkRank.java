package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] adjMatrix = new int[n][n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        int max = 0;
        for (int[] road : roads) {
            adjList.get(road[0]).add(road[1]);
            adjList.get(road[1]).add(road[0]);
            adjMatrix[road[0]][road[1]] = 1;
            adjMatrix[road[1]][road[0]] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int rank = 0;
                rank += adjList.get(i).size();
                rank += adjList.get(j).size();
                if (adjMatrix[i][j] == 1) rank -= 1;
                if (rank > max) max = rank;
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }


}
