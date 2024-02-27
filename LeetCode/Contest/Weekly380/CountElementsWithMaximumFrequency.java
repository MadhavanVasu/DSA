package LeetCode.Contest.Weekly380;

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency {

    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int result = 0;
        for (int x : nums) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
            if (freqMap.get(x) > maxFreq) {
                maxFreq = freqMap.get(x);
                result = maxFreq;
            } else if (freqMap.get(x) == maxFreq) {
                result += maxFreq;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }


}
