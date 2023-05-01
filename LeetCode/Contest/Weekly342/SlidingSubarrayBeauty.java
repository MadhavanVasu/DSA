package LeetCode.Contest.Weekly342;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingSubarrayBeauty {

    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            if (pq.size() < x)
                pq.add(nums[i]);
            else if (pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        result[0] = pq.peek();
        int j = 1;
        for (int i = k; i < n; i++) {
            pq.remove(nums[i - k]);
            if (pq.size() < x)
                pq.add(nums[i]);
            else if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
            if (pq.peek() <= 0) {
                result[j] = pq.peek();
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, -3, -2, 3};
        int k = 3;
        int x = 2;
        System.out.println(Arrays.toString(getSubarrayBeauty(nums, k, x)));
    }

}
