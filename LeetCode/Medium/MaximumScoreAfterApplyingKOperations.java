package LeetCode.Medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumScoreAfterApplyingKOperations {

    public long maxKelements(int[] nums, int k) {
        long result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : nums) pq.add(x);
        while (k-- > 0) {
            int x = pq.poll();
            result += x;
            int newNum = (x + 2) / 3;
            pq.add(newNum);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
