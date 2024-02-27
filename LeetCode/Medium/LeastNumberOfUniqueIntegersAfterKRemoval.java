package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class LeastNumberOfUniqueIntegersAfterKRemoval {

    // O(N) -> Using frequency array
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int x : arr) freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        int[] possibleFreqs = new int[arr.length + 1];
        for (int x : freqMap.values()) possibleFreqs[x]++;
        for (int i = 0; i < possibleFreqs.length && k > 0; i++) {
            if (possibleFreqs[i] != 0) {
                while (possibleFreqs[i] != 0) {
                    if (i <= k) {
                        k -= i;
                        possibleFreqs[i]--;
                    } else {
                        k = 0;
                        break;
                    }
                }
            }
        }
        int result = 0;
        for (int x : possibleFreqs) result += x;
        return result;
    }

    // O(N log(N)) -> Using HashMap & Priority Queue
//    public int findLeastNumOfUniqueInts(int[] arr, int k) {
//        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
//        Map<Integer, Integer> freqMap = new HashMap<>();
//        for (int x : arr) freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
//        for (int x : freqMap.keySet()) pq.add(new int[]{x, freqMap.get(x)});
//        while (k != 0) {
//            int freq = pq.peek()[1];
//            if (freq <= k) {
//                k -= freq;
//                pq.poll();
//            } else break;
//        }
//        return pq.size();
//    }

}
