package LeetCode.Medium;

import java.util.HashMap;
import java.util.Map;

public class MinDeletetionToMakeEqualFreq {

    public int minDeletions(String s) {
        int maxFreq = 0;
        Map<Character, Integer> charFreq = new HashMap<>();

        for (Character x : s.toCharArray()) {
            charFreq.put(x, charFreq.getOrDefault(x, 0) + 1);
            int freq = charFreq.get(x);
            if (freq > maxFreq) maxFreq = freq;
        }

        int[] freqArr = new int[maxFreq + 1];
        for (Character x : charFreq.keySet()) {
            freqArr[charFreq.get(x)]++;
        }

        int remove = 0;
        for (int i = maxFreq; i > 0; i--) {
            if (freqArr[i] > 1) {
                remove += (freqArr[i] - 1);
                freqArr[i - 1] += remove;
            }
        }
        return remove;
    }

    public static void main(String[] args) {

    }

}
