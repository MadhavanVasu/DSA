package LeetCode.Contest.Biweekly126;

import java.util.PriorityQueue;

public class MarkElementsOnArrayByPerformingQueries {

    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        long[] result = new long[m];
        long sum = 0;
        for (int x : nums) sum += x;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] < b[0]) return -1;
            if (a[0] > b[0]) return 1;
            return Integer.compare(a[1], b[1]);
        });
        boolean[] marked = new boolean[n];
        for (int i = 0; i < n; i++) pq.add(new int[]{nums[i], i});
        for (int i = 0; i < m; i++) {
            int ele = queries[i][0];
            int k = queries[i][1];
            if (sum == 0) break;
            if (!marked[ele]) {
                marked[ele] = true;
                sum -= nums[ele];
            }

            while (k != 0 && !pq.isEmpty()) {
                int[] arr = pq.poll();
                if (!marked[arr[1]]) {
                    marked[arr[1]] = true;
                    sum -= arr[0];
                    k--;
                }
            }
            result[i] = sum;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
