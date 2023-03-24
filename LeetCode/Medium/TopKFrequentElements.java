package LeetCode.Medium;

import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequentLinear(int[] nums, int k) {

        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);
        List<List<Integer>> freqBucket = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) freqBucket.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> x : map.entrySet())
            freqBucket.get(x.getValue()).add(x.getKey());
        int ind = 0;
        for (int i = nums.length; i >= 0; i--) {
            for (int x : freqBucket.get(i)) {
                res[ind++] = x;
                if (ind == k)
                    return res;
            }
        }
        return res;

    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        System.out.println(map);
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));
        for (int x : map.keySet()) {
            if (pq.size() < k)
                pq.add(new ArrayList<>(List.of(map.get(x), x)));
            else if (pq.peek().get(0) < map.get(x)) {
                pq.poll();
                pq.add(new ArrayList<>(List.of(map.get(x), x)));
            }
        }
        int[] res = new int[k];
        int i = 0;
        System.out.println(pq);
        while (!pq.isEmpty()) {
            List<Integer> temp = pq.poll();
            res[i++] = temp.get(1);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(topKFrequentLinear(nums, 2)));

    }

}
