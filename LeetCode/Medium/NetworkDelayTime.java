package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        // Dijkstra Algorithm
        List<List<List<Integer>>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] time : times) {
            adjList.get(time[0] - 1).add(new ArrayList<>(List.of(time[1] - 1, time[2])));
        }
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.get(0) < b.get(0)) return -1;
            if (a.get(1) > b.get(0)) return 1;
            return 0;
        });
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[k - 1] = 0;
        minHeap.add(new ArrayList<>(List.of(0, k - 1)));
        while (!minHeap.isEmpty()) {
            List<Integer> ele = minHeap.poll();
            for (List<Integer> x : adjList.get(ele.get(1))) {
                int dist = ele.get(0) + x.get(1);
                if (distance[x.get(0) - 1] > dist) {
                    distance[x.get(0) - 1] = dist;
                    minHeap.add(new ArrayList<>(List.of(dist, x.get(0) - 1)));
                }
            }

        }
        int max = 0;
        for (int x : distance) max = max < x ? x : max;
        max = max == Integer.MAX_VALUE ? 0 : max;
        return max;
    }

    public static void main(String[] args) {
        int[][] times = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        System.out.println(new NetworkDelayTime().networkDelayTime(times, n, k));

    }

}
