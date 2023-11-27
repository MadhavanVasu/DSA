package LeetCode.Contest.Biweekly114;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToMakeEmpty {

    public int minOperations(int[] nums) {
        int n = nums.length;
        Integer[] possibleFrequencies = new Integer[n + 1];
        possibleFrequencies[2] = 1;
        if (n >= 3)
            possibleFrequencies[3] = 1;
        for (int i = 2; i <= n; i++) {
            if (possibleFrequencies[i] != null) {
                if (i + 2 <= n && possibleFrequencies[i + 2] == null)
                    possibleFrequencies[i + 2] = possibleFrequencies[i] + 1;
                if (i + 3 <= n && possibleFrequencies[i + 3] == null)
                    possibleFrequencies[i + 3] = possibleFrequencies[i] + 1;
            }
        }

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int x : nums) frequencies.put(x, frequencies.getOrDefault(x, 0) + 1);

        int result = 0;
        for (int x : frequencies.keySet()) {
            int freq = frequencies.get(x);
            if (possibleFrequencies[freq] != null) {
                result += possibleFrequencies[freq];
            } else return -1;
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
