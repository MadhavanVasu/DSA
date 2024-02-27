package LeetCode.Contest.Weekly386;

import java.util.HashMap;
import java.util.Map;

public class SplitTheArray {

    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int x : nums) freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        int singleOccur = 0;
        for (int x : freqMap.keySet()) {
            if (freqMap.get(x) == 1) singleOccur++;
            if (freqMap.get(x) > 2) return false;
        }
        return singleOccur % 2 == 0;
    }

    public static void main(String[] args) {

    }

}
