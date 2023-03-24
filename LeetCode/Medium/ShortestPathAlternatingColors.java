package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ShortestPathAlternatingColors {

    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        int[] result = new int[n];
        List<List<Integer>> redAdjList = new ArrayList<>();
        List<List<Integer>> blueAdjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            redAdjList.add(new ArrayList<>());
            blueAdjList.add(new ArrayList<>());
        }

        for (int[] x : redEdges)
            redAdjList.get(x[0]).add(x[1]);

        for (int[] x : blueEdges)
            blueAdjList.get(x[0]).add(x[1]);

        for (int i = 1; i < n; i++)
            result[i] = -1;
        LinkedList<Integer> queue = new LinkedList<>();
        int i = 0;
        queue.add(0);
        int dist = 1;
        int[] visitedRed = new int[n];
        int[] visitedBlue = new int[n];
        visitedRed[0] = 1;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize-- != 0) {
                int v = queue.poll();
                List<Integer> adj;
                if (i % 2 == 0) {
                    adj = redAdjList.get(v);
                    for (int x : adj) {
                        if (visitedBlue[x] != 1) {
                            if (result[x] == -1 || dist < result[x])
                                result[x] = dist;
                            queue.add(x);
                            visitedBlue[x] = 1;
                        }
                    }

                } else {
                    adj = blueAdjList.get(v);
                    for (int x : adj) {
                        if (visitedRed[x] != 1) {
                            if (result[x] == -1 || dist < result[x])
                                result[x] = dist;
                            queue.add(x);
                            visitedRed[x] = 1;
                        }
                    }
                }
            }
            i++;
            dist++;
        }
        queue = new LinkedList<>();
        i = 0;
        queue.add(0);
        dist = 1;
        visitedBlue = new int[n];
        visitedRed = new int[n];
        visitedBlue[0] = 1;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            while (qSize-- != 0) {
                int v = queue.poll();
                List<Integer> adj;
                if (i % 2 == 0) {
                    adj = blueAdjList.get(v);
                    for (int x : adj) {
                        if (visitedRed[x] != 1) {
                            if (result[x] == -1 || dist < result[x])
                                result[x] = dist;
                            queue.add(x);
                            visitedRed[x] = 1;
                        }
                    }
                } else {
                    adj = redAdjList.get(v);
                    for (int x : adj) {
                        if (visitedBlue[x] != 1) {
                            if (result[x] == -1 || dist < result[x])
                                result[x] = dist;
                            queue.add(x);
                            visitedBlue[x] = 1;
                        }
                    }
                }
            }
            i++;
            dist++;
        }
        return result;
    }

    public static void main(String[] args) {

        int n = 5;
        int[][] redEdges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[][] blueEdges = {{1, 2}, {2, 3}, {3, 1}};
        System.out.println(Arrays.toString(shortestAlternatingPaths(n, redEdges, blueEdges)));

    }

}
