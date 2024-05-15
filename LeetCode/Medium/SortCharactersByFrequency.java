package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public String frequencySortUsingMap(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));
        pq.addAll(freqMap.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            int freq = entry.getValue();
            while (freq-- != 0) sb.append(entry.getKey());
        }
        return sb.toString();
    }

    public String frequencySort(String s) {
        int[] upperCharFreq = new int[26];
        int[] lowerCharFreq = new int[26];
        int[] digitFreq = new int[10];
        for (char c : s.toCharArray()) {
            if (c >= 65 && c <= 90) upperCharFreq[c - 'A']++;
            else if (c >= 97 && c <= 122) lowerCharFreq[c - 'a']++;
            else digitFreq[c - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> b[0].compareTo(a[0]));
        for (int i = 0; i < 26; i++) {
            if (upperCharFreq[i] != 0) pq.add(new Integer[]{upperCharFreq[i], i + 'A'});
            if (lowerCharFreq[i] != 0) pq.add(new Integer[]{lowerCharFreq[i], i + 'a'});
            if (i < 10 && digitFreq[i] != 0) pq.add(new Integer[]{digitFreq[i], i + '0'});
        }
        while (!pq.isEmpty()) {
            Integer[] ele = pq.poll();
            int freq = ele[0];
            char c = (char) ((int) ele[1]);
            while (freq-- != 0) sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().frequencySort("tree"));

    }

}
