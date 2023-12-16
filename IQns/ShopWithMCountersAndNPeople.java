package IQns;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ShopWithMCountersAndNPeople {
    public int[] findLeavingTime(int n, int m, int[] arrivingTime) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            minHeap.add(0);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int leastCounterTime = minHeap.poll();
            if (leastCounterTime <= arrivingTime[i]) {
                result[i] = arrivingTime[i] + 1;
            } else {
                result[i] = leastCounterTime - arrivingTime[i] + 1;
            }
            minHeap.add(result[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 2;
        int[] arrivingTime = new int[]{0, 0, 0, 0};
        System.out.println(Arrays.toString(new ShopWithMCountersAndNPeople().findLeavingTime(n, m, arrivingTime)));
    }

}
