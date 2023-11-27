package LeetCode.Hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DesignGraphWithShortestPathCalculator {

    class Graph {
        List<List<List<Integer>>> adjList;
        int n;

        public Graph(int n, int[][] edges) {
            this.n = n;
            this.adjList = new ArrayList<>();
            for (int i = 0; i < n; i++)
                adjList.add(new ArrayList<>());
            for (int[] edge : edges) {
                addEdge(edge);
            }
        }

        public void addEdge(int[] edge) {
            adjList.get(edge[0]).add(new ArrayList<>(List.of(edge[1], edge[2])));
        }

        public int shortestPath(int node1, int node2) {
            // Dijkstra Algorithm
            Integer[] minDistance = new Integer[n];
            minDistance[node1] = 0;
            Comparator<List<Integer>> customComparator = (a, b) -> {
                if (a.get(0) < b.get(0)) return -1;
                if (a.get(0) > b.get(0)) return 1;
                if (a.get(1) < b.get(1)) return -1;
                return 1;
            };
            PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(customComparator);
            minHeap.add(new ArrayList<>(List.of(0, node1)));
            while (!minHeap.isEmpty()) {
                List<Integer> vertex = minHeap.poll();
                int dist = vertex.get(0);
                int v = vertex.get(1);
                for (List<Integer> x : adjList.get(v)) {
                    int c = dist + x.get(1);
                    if (minDistance[x.get(0)] == null || minDistance[x.get(0)] > c) {
                        minDistance[x.get(0)] = c;
                        minHeap.add(new ArrayList<>(List.of(x.get(1), c)));
                    }
                }
            }
            return minDistance[node2] == null ? -1 : minDistance[node2];
        }
    }


    public static void main(String[] args) {

    }

}
