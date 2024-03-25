package LeetCode.Contest.Biweekly125;

import java.util.PriorityQueue;

public class MinimumOperationsToExceedThreshold1 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : nums) pq.add(x);
        int cnt = 0;
        while (!pq.isEmpty()) {
            if (pq.peek() >= k) break;
            pq.poll();
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {

    }

}
