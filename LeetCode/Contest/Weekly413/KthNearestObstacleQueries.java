package LeetCode.Contest.Weekly413;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthNearestObstacleQueries {

    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int n = queries.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int dist = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            if (pq.size() < k) pq.add(dist);
            else {
                if (pq.peek() > dist) {
                    pq.poll();
                    pq.add(dist);
                }
            }
            if (pq.size() == k) result[i] = pq.peek();
            else result[i] = -1;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
