package LeetCode.Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] > b[0]) return -1;
            if (a[0] < b[0]) return 1;
            return Integer.compare(b[1], a[1]);
        });
        int n = nums.length;
        int[] result = new int[n - k];
        for (int i = 0; i < k; i++) pq.add(new int[]{nums[i], i});
        for (int j = 0; j < n - k; j++) {
            while (!pq.isEmpty() && pq.peek()[1] < j) {
                pq.poll();
            }
            result[j] = pq.peek()[0];
            if (j + k < n)
                pq.add(new int[]{nums[j + k], j + k});
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
