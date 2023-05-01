package LeetCode.Medium;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentWords {


    public static List<String> topKFrequentPQ(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String x : words) map.put(x, map.getOrDefault(x, 0) + 1);
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());
        for (Map.Entry<String, Integer> x : map.entrySet()) {
            pq.offer(x);
            if (pq.size() > k) pq.poll();
        }
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) result.add(pq.poll().getKey());
        Collections.reverse(result);
        return result;
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String x : words) map.put(x, map.getOrDefault(x, 0) + 1);
        Comparator<Map.Entry<String, Integer>> comparator = (a, b) -> {
            if (b.getValue() > a.getValue()) return 1;
            else if (b.getValue() < a.getValue()) return -1;
            return a.getKey().compareTo(b.getKey());
        };
        Map<String, Integer> sortedMap = map.entrySet().stream().sorted(comparator).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        List<String> freqWords = new ArrayList<>();
        for (String word : sortedMap.keySet()) {
            if (k == 0) break;
            freqWords.add(word);
            k--;
        }
        return freqWords;
    }

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(topKFrequent(words, k));

    }

}
