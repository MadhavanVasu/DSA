package LeetCode.Contest.Weekly381;

import java.util.*;

public class CountTheNumberOfHousesCertainDistance1 {

    public int[] countOfPairs(int n, int x, int y) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            adjList.get(i).add(j);
            adjList.get(j).add(i);
        }
        if (x != y) {
            adjList.get(x - 1).add(y - 1);
            adjList.get(y - 1).add(x - 1);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            queue.add(i);
            visited.add(i);
            int level = 0;
            while (!queue.isEmpty()) {
                int qSize = queue.size();
                while (qSize-- != 0) {
                    int v = queue.poll();
                    if (v != i) {
                        result[level - 1]++;
                    }
                    for (int adj : adjList.get(v)) {
                        if (!visited.contains(adj)) {
                            visited.add(adj);
                            queue.add(adj);
                        }
                    }
                }
                level++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
