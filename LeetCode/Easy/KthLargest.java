package LeetCode.Easy;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {

        minHeap = new PriorityQueue<>();
        int i = 0;
        while (i < nums.length) {
            if (minHeap.size() < k)
                minHeap.add(nums[i++]);
            else if (minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.add(nums[i++]);
            }
        }

    }

    public int add(int val) {
        if (minHeap.size() == 0) {
            minHeap.add(val);
        }
        else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.peek();

    }

}
