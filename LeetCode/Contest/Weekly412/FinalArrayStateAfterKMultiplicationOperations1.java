package LeetCode.Contest.Weekly412;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperations1 {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] < b[0]) return -1;
            else if (a[0] > b[0]) return 1;
            else if (a[1] < b[1]) return -1;
            else if (a[1] > b[1]) return 1;
            return 0;
        });
        int n = nums.length;
        for (int i = 0; i < n; i++) pq.add(new int[]{nums[i], i});
        int[] result = Arrays.copyOf(nums, n);
        while (k-- > 0) {
            int[] ele = pq.poll();
            result[ele[1]] = ele[0] * multiplier;
            pq.add(new int[]{ele[0] * multiplier, ele[1]});
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
