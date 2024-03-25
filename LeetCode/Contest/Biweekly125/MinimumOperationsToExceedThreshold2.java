package LeetCode.Contest.Biweekly125;

import java.util.PriorityQueue;

public class MinimumOperationsToExceedThreshold2 {

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int x : nums) pq.add((long) x);
        int result = 0;
        while (pq.size() >= 2) {
            if (pq.peek() >= k) break;
            long x = pq.poll();
            if (pq.isEmpty()) break;
            long y = pq.poll();
            long newEle = Math.min(x, y) * 2 + Math.max(x, y);
            pq.add(newEle);
            result++;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
