package LeetCode.Medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : nums)
            pq.add(x);
        for (int i = 0; i < k - 1; i++)
            pq.poll();
        return pq.peek();
    }

    public static void main(String[] args) {

    }

}
