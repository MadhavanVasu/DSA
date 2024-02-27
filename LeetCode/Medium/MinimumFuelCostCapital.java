package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class MinimumFuelCostCapital {

    int fuel = 0;

    public int helper(int i, int[] visited, List<List<Integer>> adjList, int seats) {
        visited[i] = 1;
        int nodes = 1;
        for (int x : adjList.get(i)) {
            if (visited[x] == 0) {
                nodes += helper(x, visited, adjList, seats);
            }
        }
        int r = nodes % seats;
        int q = nodes / seats;
        fuel += q;
        if (r > 0) fuel += 1;
        return nodes;
    }

    public long minimumFuelCostDFS(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] road : roads) {
            adjList.get(road[0]).add(road[1]);
            adjList.get(road[1]).add(road[0]);
        }
        int[] visited = new int[n];
        helper(0, visited, adjList, seats);
        return fuel;
    }

    static long minFuel = 0;

    public static int dfs(int i, ArrayList<ArrayList<Integer>> adjList, int seats, int prev) {
        ArrayList<Integer> adj = adjList.get(i);
        int count = 1;
        for (int x : adj) {
            if (x != prev) {
                count += dfs(x, adjList, seats, i);
            }
        }
        if (i != 0) minFuel += (Math.ceil(((double) count) / seats));
        return count;
    }

    public static long minimumFuelCost(int[][] roads, int seats) {
        int V = -1;
        for (int[] x : roads) {
            if (x[0] > V)
                V = x[0];
            if (x[1] > V)
                V = x[1];
        }
        V += 1;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());
        for (int[] x : roads) {
            adjList.get(x[0]).add(x[1]);
            adjList.get(x[1]).add(x[0]);
        }
        dfs(0, adjList, seats, 0);

        return minFuel;
    }

    public static void main(String[] args) {

        int[][] roads = {{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}};
        int seats = 2;
        System.out.println(minimumFuelCost(roads, seats));
    }

}
