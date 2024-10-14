package LeetCode.Contest.Weekly419;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindXSumOfAllKLongArrays1 {

    public int[] findXSum(int[] nums, int k, int x) {

        int n = nums.length;

        int[] result = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[1] < b[1]) return -1;
                else if (a[1] > b[1]) return 1;
                else if (a[0] < b[0]) return -1;
                else if (a[0] > b[0]) return 1;
                return 0;
            });
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                freqMap.put(nums[j], freqMap.getOrDefault(nums[i], 0) + 1);
            }

            for (int val : freqMap.keySet()) {
                if (pq.size() < x || freqMap.get(val) > pq.peek()[1] || (freqMap.get(val) == pq.peek()[1] && val > pq.peek()[0])) {
                    pq.add(new int[]{val, freqMap.get(val)});
                }
            }
            int sum = 0;
            while (!pq.isEmpty()) {
                int[] ele = pq.poll();
                sum += (ele[0] * ele[1]);
            }
            result[i] = sum;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
